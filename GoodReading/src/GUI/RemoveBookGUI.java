package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveBookGUI extends JFrame {

	private JFrame frame;
	private JTextField txtBookName;
	private static RemoveBookGUI INSTANCE3=null;

	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public RemoveBookGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		txtBookName = new JTextField();
		txtBookName.setText("Book Name");
		springLayout.putConstraint(SpringLayout.NORTH, txtBookName, 52, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtBookName, 143, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtBookName, 280, SpringLayout.WEST, frame.getContentPane());
		getContentPane().add(txtBookName);
		txtBookName.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch, 0, SpringLayout.SOUTH, txtBookName);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, -6, SpringLayout.WEST, txtBookName);
		getContentPane().add(btnSearch);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
				setVisible(false);
				frame=LibraryManagerGUI.getInstance();
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnBack);
	}
	public static RemoveBookGUI getInstance() 
	{
		
			if(INSTANCE3==null)
				INSTANCE3=new RemoveBookGUI();
		
				return INSTANCE3;
     }
}
