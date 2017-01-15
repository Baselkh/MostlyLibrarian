package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DownloadOptionGUI extends JFrame{

	private JFrame frame;
	private JFrame frame1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static DownloadOptionGUI INSTANCE2=null;
	private int flag =0;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public DownloadOptionGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("DOWNLOAD OPTION");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JRadioButton rdbtnPdf = new JRadioButton("PDF");
		buttonGroup.add(rdbtnPdf);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnPdf, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, rdbtnPdf, 10, SpringLayout.WEST, frame.getContentPane());
		getContentPane().add(rdbtnPdf);
		
		JRadioButton rdbtnDoc = new JRadioButton("DOC");
		buttonGroup.add(rdbtnDoc);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnDoc, 6, SpringLayout.SOUTH, rdbtnPdf);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnDoc, 10, SpringLayout.WEST, frame.getContentPane());
		getContentPane().add(rdbtnDoc);
		
		JRadioButton rdbtnFb = new JRadioButton("FB2");
		buttonGroup.add(rdbtnFb);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnFb, 6, SpringLayout.SOUTH, rdbtnDoc);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnFb, 0, SpringLayout.EAST, rdbtnPdf);
		getContentPane().add(rdbtnFb);
		ActionListener sliceActionListener=new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					AbstractButton aButton=(AbstractButton)e.getSource();
					flag=1;
					
				}
				};
				rdbtnPdf.addActionListener(sliceActionListener);
				rdbtnDoc.addActionListener(sliceActionListener);
				rdbtnFb.addActionListener(sliceActionListener);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==1){
				frame.setVisible(false);
				frame=PaymentOptionGUI.getInstance();
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);
				}
					
				}
				
			
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 117, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 147, SpringLayout.WEST, frame.getContentPane());
		getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("back->");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame= MemberMainGUI.getInstance();
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);
				
				
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnBack);
		

	    
	}

	public static DownloadOptionGUI getInstance() 
	{
		
			if(INSTANCE2==null)
				INSTANCE2=new DownloadOptionGUI();
		
				return INSTANCE2;
     }
	}
