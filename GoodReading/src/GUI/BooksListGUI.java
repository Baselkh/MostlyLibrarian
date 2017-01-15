package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.controller.ControllerType;
import client.controller.Controllers;
import client.controller.SubjectsController;
import client.entities.Book;
import protocol.response.AddBooksToSubjectResponse;
import protocol.response.GetAllBooksResponse;
import protocol.response.RemoveBooksFromSubjectResponse;

public class BooksListGUI extends JFrame {

	private String subjectID;
	private String subjectName;
	private JButton addButton;
	private ArrayList<BooksInSubjectElementGUI> booksGUIElements;
	
	public BooksListGUI(String subjectID, String subjectName){
		super("Adding Books To Subject");
		this.subjectID= subjectID;
		this.subjectName= subjectName;
		
		Container pane= getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		SubjectsController controller= (SubjectsController) 
				Controllers.getInstance().getController(ControllerType.SUBJECT_CONTROLLER);
		GetAllBooksResponse resp= controller.getAllBooks(subjectID);
		ArrayList<Book> books= resp.getBooks();
		
		addButton= new JButton("Add Books");
		pane.add(addButton);
		
		booksGUIElements= new ArrayList<BooksInSubjectElementGUI>();
		for(Book b : books){
			BooksInSubjectElementGUI elem= new BooksInSubjectElementGUI(b, true);
			pane.add(elem);
			booksGUIElements.add(elem);
		}
		
		addButton.addActionListener(new AddButtonHandler());
		
		// Displaying
				pack();
				setVisible(true);
	}
	
	private class AddButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<BooksInSubjectElementGUI> arr= new ArrayList<BooksInSubjectElementGUI>();
			for(BooksInSubjectElementGUI elem : booksGUIElements)
				if(elem.isSelected())
					arr.add(elem);
			if(arr.size() == 0)	// No book is selected to be added
				JOptionPane.showMessageDialog(null, "Please select books that you wish to add");
			else{	// One ore more books is selected
				ArrayList<String> booksIDs= new ArrayList<String>();
				for(BooksInSubjectElementGUI elem : arr)
					booksIDs.add(elem.getID());
				SubjectsController controller= (SubjectsController) 
						Controllers.getInstance().getController(ControllerType.SUBJECT_CONTROLLER);
				AddBooksToSubjectResponse resp= controller.addBooksToSubject(subjectID, booksIDs);
				if(resp.operationIsSuccessful()){
					new BooksInSubjectGUI(subjectID, subjectName);
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "ERROR");
			}
		}
	}
}
