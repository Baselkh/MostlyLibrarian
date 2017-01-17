package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

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
public class BooksInSubjectGUI extends AbstractQueueableWindow {

	private JTable table;
	private int numOfRows, numOfCols;
	private String subjectName;
	private String subjectID;
	private JButton addBookButton;
	private JButton removeBookButton;
	private ArrayList<Book> books;

	public BooksInSubjectGUI(String subjectID, String subjectName){
		super(subjectName);

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

		// Creating the table
		numOfRows = books.size();
		numOfCols = 9;
		Object[][] data = new Object[numOfRows][numOfCols];

		int i = 0;
		for(Book b: books){
			int j = 0;
			data[i][j] = new Boolean(false);
			j++;
			data[i][j] = b.getBookID();
			j++;
			data[i][j] = b.getTitle();
			j++;
			data[i][j] = b.getLanguage();
			j++;
			data[i][j] = b.getSummary();
			j++;
			data[i][j] = b.getTableOfContents();
			j++;
			data[i][j] = b.getDownloadsNumber();
			j++;
			data[i][j] = b.getKeywords();
			j++;
			data[i][j] = b.getAuthors();
			i++;
		}

		table = new JTable(new MyTableModel(data));
		table.setPreferredScrollableViewportSize(new Dimension(500, 300));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(
				ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		//Add the scroll pane to this panel.
		pane.add(scrollPane);

		// Setting up buttons listeners
		ClickHandler handler= new ClickHandler();
		addBookButton.addActionListener(handler);
		removeBookButton.addActionListener(handler);

		// Back button
		pane.add(Box.createRigidArea(new Dimension(1, 40)));
		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowsViewManager.removeFromQueue();
			}
		});
		pane.add(backButton);
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(Box.createRigidArea(new Dimension(1, 80)));		

		// Displaying
		pack();
		setVisible(true);
	}

	class MyTableModel extends AbstractTableModel {
		String[] columnNames = {"",
				"Book ID",
				"Title", 
				"Language", 
				"Summary", 
				"Table of Contents", 
				"Downloads Number", 
				"Keywords", 
		"Authors"};
		private Object[][] data;

		public MyTableModel(Object[][] data){
			this.data= data;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		/*
		 * JTable uses this method to determine the default renderer/
		 * editor for each cell.  If we didn't implement this method,
		 * then the last column would contain text ("true"/"false"),
		 * rather than a check box.
		 */
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/*
		 * Don't need to implement this method unless your table's
		 * editable.
		 */
		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			if (col == 0) {
				return true;
			} else {
				return false;
			}
		}

		/*
		 * Don't need to implement this method unless your table's
		 * data can change.
		 */
		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}

	}

	private class ClickHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			if(a.getSource() == addBookButton){
				new AddBooksToSubjectGUI(subjectID, subjectName);
			}
			else if(a.getSource() == removeBookButton){
				ArrayList<String> booksIDs = new ArrayList<String>();
				for(int i = 0; i < numOfRows; i++)
					if((Boolean)table.getValueAt(i, 0))
						booksIDs.add((String)table.getValueAt(i, 1));

				if(booksIDs.size() == 0)	// No book is selected to be removed
					JOptionPane.showMessageDialog(null, "Please select books that you wish to remove");
				else{	// One ore more books is selected
					SubjectsController controller= (SubjectsController) 
							Controllers.getInstance().getController(ControllerType.SUBJECT_CONTROLLER);
					RemoveBooksFromSubjectResponse resp= controller.removeBooksFromSubject(booksIDs);
					if(resp.getOperationStatus()){
						WindowsViewManager.removeFromQueue();
						new BooksInSubjectGUI(subjectID, subjectName);
					}
					else{
						JOptionPane.showMessageDialog(null, "ERROR");
						removeFromQueue();
					}
				}
			}
		}
	}
}
