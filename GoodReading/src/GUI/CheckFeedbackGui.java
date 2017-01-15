package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class CheckFeedbackGui extends JFrame{
	private static CheckFeedbackGui INSTANCE4=null;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public CheckFeedbackGui() {
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
		
		JButton btnCheckFeedvack = new JButton("check feedvack");
		springLayout.putConstraint(SpringLayout.NORTH, btnCheckFeedvack, 114, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCheckFeedvack, 105, SpringLayout.WEST, frame.getContentPane());
		getContentPane().add(btnCheckFeedvack);
		
		
		
		JButton btnBack_1 = new JButton("back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);	
					setVisible(false);
					frame=LibraryManagerGUI.getInstance();
					frame.setBounds(100, 100, 450, 300);
					frame.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnBack_1, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack_1, 0, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnBack_1);
		
		
	}
public static CheckFeedbackGui getInstance(){
	if(INSTANCE4==null)
		INSTANCE4=new CheckFeedbackGui();
	
	return INSTANCE4;
	
}
}
