package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.controller.ControllerType;
import client.controller.Controllers;
import client.controller.LoginController;
import client.entities.User;
import client.ui.ClientUI;
import protocol.response.LoginResponse;

public class Login {

	private JFrame frame;
	private JTextField textFieldID;///
	private JLabel lblPassword;////
	private JPasswordField passwordField;////
	private JLabel lblPleaseLogin;
	private JLabel lblId;
	private JButton btnOk;
	private static Login INSTANCE = null;
	private JButton btnGuest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	private void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initialize();
	}
	
	/**
	 * This function check if there is an instance for the form, if no , create
	 * it else, return the INSTANCE
	 */
	public static Login getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Login();
		}
		INSTANCE.display();
		return INSTANCE;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/**
		 * Creating and designing the Login Frame
		 */
		
		frame = new JFrame("LOGIN");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Welcome to the Library");
		frame.setBounds(0, -21, 668, 400);
		frame.setLocation(330, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**
		 * Creating and designing the "Please Login" Label
		 */
		
		lblPleaseLogin = new JLabel("Please Login : ");
		lblPleaseLogin.setForeground(new Color(30, 144, 255));
		lblPleaseLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPleaseLogin.setBounds(364, 128, 126, 24);
		frame.getContentPane().add(lblPleaseLogin);
		
		/**
		 * Creating and designing the ID TextField
		 */
		
		textFieldID = new JTextField();
		textFieldID.setBounds(432, 161, 189, 24);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(9);
		
		/**
		 * Creating and designing the "Password" Label
		 */
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblPassword.setBounds(361, 196, 69, 24);
		frame.getContentPane().add(lblPassword);
		
		/**
		 * Creating and designing the Password TextField
		 */
		
		passwordField = new JPasswordField();
		passwordField.setBounds(432, 198, 189, 24);
		frame.getContentPane().add(passwordField);
		
		
		/**
		 * Creating and designing the "ID" Label
		 */
		
		lblId = new JLabel("Username:");
		lblId.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblId.setBounds(361, 161, 61, 24);
		frame.getContentPane().add(lblId);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (passwordField.getText().equals("")&&!(textFieldID.getText().equals("")))
					JOptionPane.showMessageDialog(null," please enter your Password");
				else{
					if(textFieldID.getText().equals("")&&!(passwordField.getText().equals("")))
						JOptionPane.showMessageDialog(null," please enter your ID");
					else{
						if(textFieldID.getText().equals("")&&passwordField.getText().equals("")){
							JOptionPane.showMessageDialog(null," please enter your ID and your Password");
						}
					}
				}
				
				User user = new User(textFieldID.getText(), passwordField.getText());
				LoginController login = (LoginController) Controllers
						.getInstance().getController(ControllerType.LOGIN_CONTROLLER);
				LoginResponse resp = login.checkLoginDetailsFromGUI(user);
				
				if(resp.getText().equals("OK")||resp.getText().equals("Already Logged In!"))
				{
				ClientUI.currUser=resp.getUser();
				int type=ClientUI.currUser.getUserType();
				
				switch(type){
				
				case 1://user
				{
					///null
					
					}
				case 2://member
				{
					frame.setVisible(false);
					frame=MemberMainGUI.getInstance();
					frame.setBounds(100, 100, 450, 300);
					frame.setVisible(true);
					break;
					}
				case 3://Certified editor
				{

					
					}
				case 4://liberian
				{
					new CategoriesGUI();
					frame.setVisible(false);
					break;
				}
				
				case 5://library manager
				{
					frame.setVisible(false);
					frame=LibraryManagerGUI.getInstance();
					frame.setBounds(100, 100, 450, 300);
					frame.setVisible(true);
					break;
					}
				}
				
					
				}
				else{
					
					JLabel lblStatus = new JLabel(resp.getText());
					lblStatus.setForeground(Color.RED);
					lblStatus.setBounds(432, 299, 46, 14);
					frame.getContentPane().add(lblStatus);
					
				}
				
			}
		});
		
		btnOk.setBounds(520, 259, 89, 23);
		frame.getContentPane().add(btnOk);
		
		btnGuest = new JButton("Guest?");
		btnGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame=UserGUI.getInstance();
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);
			}
		});
		btnGuest.setBounds(564, 327, 78, 23);
		frame.getContentPane().add(btnGuest);
		
		//Image imgok = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		//btnLogin.setIcon(new ImageIcon(imgok));
		
	}
}
