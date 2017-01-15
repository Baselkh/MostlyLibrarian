package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;


public class BookReportGUI extends JFrame {
	private static BookReportGUI INSTANCE=null;
	private JFrame frame;
    private String Bookid;
    
	public String getBookid() {
		return Bookid;
	}

	public void setBookid(String bookid) {
		Bookid = bookid;
	}

	/**
	 * Launch the application.
	 */
	public void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookReportGUI() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setTitle("Book report");
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

	
	public static BookReportGUI getInstance(){
		if(INSTANCE==null)
			INSTANCE=new BookReportGUI();
		
	
			return INSTANCE;
	}


}
