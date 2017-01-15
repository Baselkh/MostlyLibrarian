package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import client.controller.ControllerType;
import client.controller.Controllers;
import client.controller.SubjectsController;
import client.entities.Book;
import protocol.response.BooksInSubjectResponse;
import protocol.response.RemoveBooksFromSubjectResponse;

/**
 * @author Basel
 *
 */
public class BooksInSubjectGUI extends JFrame {

	private String subjectName;
	private String subjectID;
	private JButton addBookButton;
	private JButton removeBookButton;
	private ArrayList<BooksInSubjectElementGUI> booksGUIElements;
	private ArrayList<Book> books;
	private static BooksInSubjectGUI currentInstance;
	
	public BooksInSubjectGUI(String subjectID, String subjectName){
		super(subjectName);
		if(currentInstance != null)
			currentInstance.dispose();
		currentInstance= this;
		this.subjectID= subjectID;
		this.subjectName= subjectName;
		Container pane= getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		SubjectsController controller= (SubjectsController) 
				Controllers.getInstance().getController(ControllerType.SUBJECT_CONTROLLER);
		BooksInSubjectResponse resp= controller.getBooksInSubject(subjectID);
		books= resp.getBooks();
		
		// Initializing up buttons
		addBookButton= new JButton("Add Book");
		removeBookButton= new JButton("Remove Book");
		JPanel buttonsContainer= new JPanel(new FlowLayout());
		buttonsContainer.add(addBookButton);
		buttonsContainer.add(removeBookButton);
		pane.add(buttonsContainer);
		
		Book columnesNames= new Book("Book ID", "Title", "Language", "Summary", "Table of Contents", "Downloads Number", "Keywords", "Authors");
		pane.add(new BooksInSubjectElementGUI(columnesNames, false));
		
		booksGUIElements= new ArrayList<BooksInSubjectElementGUI>();
		for(Book b: books){
			BooksInSubjectElementGUI bookGUIElement= new BooksInSubjectElementGUI(b, true);
			pane.add(bookGUIElement);
			booksGUIElements.add(bookGUIElement);
		}
		
		// Setting up buttons listeners
		ClickHandler handler= new ClickHandler();
		addBookButton.addActionListener(handler);
		removeBookButton.addActionListener(handler);
		
		// Displaying
		pack();
		setVisible(true);
	}
	
	private class ClickHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			if(a.getSource() == addBookButton){
				new BooksListGUI(subjectID, subjectName);
			}
			else if(a.getSource() == removeBookButton){
				ArrayList<BooksInSubjectElementGUI> arr= new ArrayList<BooksInSubjectElementGUI>();
				for(BooksInSubjectElementGUI elem: booksGUIElements)
					if(elem.isSelected())
						arr.add(elem);
				if(arr.size() == 0)	// No book is selected to be removed
					JOptionPane.showMessageDialog(null, "Please select books that you wish to remove");
				else{	// One ore more books is selected
					ArrayList<String> booksIDs= new ArrayList<String>();
					for(BooksInSubjectElementGUI elem: arr)
						booksIDs.add(elem.getID());
					SubjectsController controller= (SubjectsController) 
							Controllers.getInstance().getController(ControllerType.SUBJECT_CONTROLLER);
					RemoveBooksFromSubjectResponse resp= controller.removeBooksFromSubject(booksIDs);
					if(resp.getOperationStatus())
						new BooksInSubjectGUI(subjectID, subjectName);
					else
						JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		}
		
	}
}
