package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import client.controller.ControllerType;
import client.controller.Controllers;
import client.controller.FeedbackController;
import client.controller.LoginController;
import client.entities.Book;
import client.entities.Purchases;
import client.entities.User;
import protocol.response.FeedbackResponse;
import protocol.response.LoginResponse;

public class UserGUI extends JFrame{

	/**
	 * 
	 */
	private String book_feild;
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtInsertTheText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static UserGUI INSTANCE2=null;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public UserGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		txtInsertTheText = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtInsertTheText, 244, SpringLayout.WEST, getContentPane());
		
		getContentPane().add(txtInsertTheText);
		
		txtInsertTheText.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Author");
		springLayout.putConstraint(SpringLayout.WEST, txtInsertTheText, 0, SpringLayout.WEST, rdbtnNewRadioButton);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 28, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton, 69, SpringLayout.WEST, getContentPane());
		buttonGroup.add(rdbtnNewRadioButton);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Title");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_1, 6, SpringLayout.SOUTH, rdbtnNewRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_1, 0, SpringLayout.WEST, rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Addtional Key");
		springLayout.putConstraint(SpringLayout.NORTH, txtInsertTheText, 24, SpringLayout.SOUTH, rdbtnNewRadioButton_2);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_2, 6, SpringLayout.SOUTH, rdbtnNewRadioButton_1);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_2, 0, SpringLayout.WEST, rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_2);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_feild=txtInsertTheText.getText();
				if(rdbtnNewRadioButton.isSelected())
				{
					Purchases pur=new Purchases(book_feild,1);
					FeedbackController feed_con = (FeedbackController) Controllers
							.getInstance().getController(ControllerType.SEARCH_FEEDBACK_CONTROLLER);
					FeedbackResponse resp = feed_con.selectfieldFromGUI(pur,1);
				}
				else
				{
					if(rdbtnNewRadioButton_2.isSelected())
					{
						Purchases pur=new Purchases(book_feild,2);
						FeedbackController feed_con = (FeedbackController) Controllers
								.getInstance().getController(ControllerType.SEARCH_FEEDBACK_CONTROLLER);
						FeedbackResponse resp = feed_con.selectfieldFromGUI(pur,2);
					}
					else
					{
						Purchases pur=new Purchases(book_feild,3);
						FeedbackController feed_con = (FeedbackController) Controllers
								.getInstance().getController(ControllerType.SEARCH_FEEDBACK_CONTROLLER);
						FeedbackResponse resp = feed_con.selectfieldFromGUI(pur,3);
					}
				}
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnSearch, 22, SpringLayout.SOUTH, txtInsertTheText);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, 0, SpringLayout.EAST, txtInsertTheText);
		getContentPane().add(btnSearch);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnNewButton);
		
	}
	public static UserGUI getInstance() 
	{
		
			if(INSTANCE2==null)
				INSTANCE2=new UserGUI();
		
				return INSTANCE2;
     }
}
