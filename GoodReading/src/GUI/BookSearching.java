package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import client.controller.ControllerType;
import client.controller.Controllers;
import client.controller.SearchController;
import client.entities.Book;
import protocol.response.searchResponse;

public class BookSearching {

	private JFrame frmBookSearch;
	private JTable table;
	private JTable table_1;
	private JTextField txtInsertBookName;
	private JTextField txtInsertBookId;
	private JTextField txtInsertBookAuthor;
	private String BookName;
	private String BookID;
	private String BookAuthor;
	private String BookLanguage;
	private JTextField txtInsertBoolLanguage;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSearching window = new BookSearching();
					window.frmBookSearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public BookSearching() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBookSearch = new JFrame();
		frmBookSearch.setTitle("BOOK SEARCH");
		frmBookSearch.setBounds(100, 100, 450, 300);
		frmBookSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmBookSearch.getContentPane().setLayout(springLayout);
		
		JButton btnSearch = new JButton("search ");
		springLayout.putConstraint(SpringLayout.WEST, btnSearch, 10, SpringLayout.WEST, frmBookSearch.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch, -21, SpringLayout.SOUTH, frmBookSearch.getContentPane());
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
			
		});
		frmBookSearch.getContentPane().add(btnSearch);
		
		txtInsertBookName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtInsertBookName, 25, SpringLayout.NORTH, frmBookSearch.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtInsertBookName, 27, SpringLayout.WEST, frmBookSearch.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtInsertBookName, -279, SpringLayout.EAST, frmBookSearch.getContentPane());
		txtInsertBookName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookName=txtInsertBookName.getText();
			}
		});
		txtInsertBookName.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	txtInsertBookName.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	txtInsertBookName.setText("Insert Book Name");
		    }
		});
		txtInsertBookName.setText("Insert Book name");
		frmBookSearch.getContentPane().add(txtInsertBookName);
		txtInsertBookName.setColumns(10);
		
		txtInsertBookId = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtInsertBookId, 17, SpringLayout.SOUTH, txtInsertBookName);
		springLayout.putConstraint(SpringLayout.WEST, txtInsertBookId, 0, SpringLayout.WEST, txtInsertBookName);
		springLayout.putConstraint(SpringLayout.EAST, txtInsertBookId, -279, SpringLayout.EAST, frmBookSearch.getContentPane());
		txtInsertBookId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookID=txtInsertBookId.getText();
			}
		});
		txtInsertBookId.setText("Insert Book ID");
		txtInsertBookId.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	txtInsertBookId.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	txtInsertBookId.setText("Insert Book ID");
		    }
		});
		frmBookSearch.getContentPane().add(txtInsertBookId);
		txtInsertBookId.setColumns(10);
		
		txtInsertBookAuthor = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtInsertBookAuthor, 20, SpringLayout.SOUTH, txtInsertBookId);
		springLayout.putConstraint(SpringLayout.WEST, txtInsertBookAuthor, 0, SpringLayout.WEST, txtInsertBookName);
		springLayout.putConstraint(SpringLayout.EAST, txtInsertBookAuthor, -279, SpringLayout.EAST, frmBookSearch.getContentPane());
		txtInsertBookAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAuthor=txtInsertBookAuthor.getName();
				
			}
		});
		txtInsertBookAuthor.setText("Insert Book Author");
		txtInsertBookAuthor.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	txtInsertBookAuthor.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	txtInsertBookAuthor.setText("Insert Book Author");
		    }
		});
		frmBookSearch.getContentPane().add(txtInsertBookAuthor);
		txtInsertBookAuthor.setColumns(10);
		
		txtInsertBoolLanguage = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtInsertBoolLanguage, 20, SpringLayout.SOUTH, txtInsertBookAuthor);
		springLayout.putConstraint(SpringLayout.WEST, txtInsertBoolLanguage, 0, SpringLayout.WEST, txtInsertBookName);
		springLayout.putConstraint(SpringLayout.EAST, txtInsertBoolLanguage, -279, SpringLayout.EAST, frmBookSearch.getContentPane());
		txtInsertBoolLanguage.setText("Insert Book Language");
		txtInsertBoolLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookLanguage=txtInsertBoolLanguage.getName();
				
			}
		});
		txtInsertBoolLanguage.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	txtInsertBoolLanguage.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	txtInsertBoolLanguage.setText("Insert Book Language");
		    }
		});
		frmBookSearch.getContentPane().add(txtInsertBoolLanguage);
		txtInsertBoolLanguage.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		Book book= new Book(BookID,BookName,BookLanguage,BookAuthor);
		SearchController search = (SearchController) Controllers
				.getInstance().getController(ControllerType.SEARCH_BOOK_CONTROLLER);
		searchResponse resp=search.checkBookDetailsFromGUI(book);
		if(resp.getText().equals("OK"))
		{
		////login menu is here 
		
			
		}
		else{
			
			
		}
		
	}
}
