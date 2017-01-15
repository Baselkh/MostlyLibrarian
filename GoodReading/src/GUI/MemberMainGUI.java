package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import client.controller.ControllerType;
import client.controller.Controllers;
import client.controller.LoginController;
import client.ui.ClientUI;
import protocol.response.LogoutResponse;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberMainGUI extends JFrame{

	private JFrame frame;
	private static MemberMainGUI INSTANCE=null;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public MemberMainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setTitle("Member Main ");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JButton btnNewButton = new JButton("Purchasing books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame=DownloadOptionGUI.getInstance();
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 48, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 77, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnNewButton);
		
		JButton btnAddFeedback = new JButton("Add FeedBack");
		btnAddFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame=AddFeedbackGUI.getInstance();
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAddFeedback, 52, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnAddFeedback, 0, SpringLayout.WEST, btnNewButton);
		getContentPane().add(btnAddFeedback);
		
		JButton btnBack = new JButton("Log out");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginController logout = (LoginController) Controllers
						.getInstance().getController(ControllerType.LOGIN_CONTROLLER);
				LogoutResponse res = logout.logoutUser(ClientUI.currUser);
				System.out.println(res.getText());
				ClientUI.currUser = null;
				setVisible(false);	
				Login.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnBack);
	}
	public static MemberMainGUI getInstance() 
	{
		
			if(INSTANCE==null)
				INSTANCE=new MemberMainGUI();
		
				return INSTANCE;
     }
}