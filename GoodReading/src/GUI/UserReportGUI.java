package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;


public class UserReportGUI extends JFrame {
	
	private static UserReportGUI INSTANCE1=null;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public UserReportGUI() {
		initialize();
	}
	

	/**
	 * Create the application.
	 */


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setTitle("user report");
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		JButton btnBannejeje = new JButton("hello");
		springLayout.putConstraint(SpringLayout.NORTH, btnBannejeje, 85, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnBannejeje, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnBannejeje);
		
		JButton btnBack = new JButton("back");
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, getContentPane());
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame=ReportGui.getInstance();
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);
				
				
			}
		});
		getContentPane().add(btnBack);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public static UserReportGUI getInstance(){
		if(INSTANCE1==null)
			INSTANCE1=new UserReportGUI();
			 
		return INSTANCE1;
	}

}
