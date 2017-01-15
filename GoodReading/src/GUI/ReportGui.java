package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class ReportGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtInsertUserId;
	private JTextField txtInsertBookId;
	private static ReportGui INSTANCE2=null;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the application.
	 */
	public ReportGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setTitle("report option ");
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		JButton btnSearch = new JButton("search");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearch, 82, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnSearch, 54, SpringLayout.WEST, frame.getContentPane());
		getContentPane().add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    setVisible(false);
			    BookReportGUI frame1;
				frame1=BookReportGUI.getInstance();
				frame1.setBookid(txtInsertBookId.getText());
				frame1.setBounds(100, 100, 450, 300);
				frame1.setVisible(true);
			}
		});
		
		
		JButton btnSearch_1 = new JButton("search");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearch_1, 21, SpringLayout.SOUTH, btnSearch);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch_1, 0, SpringLayout.EAST, btnSearch);
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame=UserReportGUI.getInstance();
				setVisible(false);
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);
			}
		});
	
		
		getContentPane().add(btnSearch_1);
		
		txtInsertUserId = new JTextField("Insert Book id");
		txtInsertUserId.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	txtInsertUserId.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	txtInsertUserId.setText("Inset User Id");
		    }
		});
		txtInsertUserId.setBackground(SystemColor.text);
		txtInsertUserId.setToolTipText("");
		springLayout.putConstraint(SpringLayout.WEST, txtInsertUserId, 21, SpringLayout.EAST, btnSearch);
		getContentPane().add(txtInsertUserId);
		txtInsertUserId.setColumns(10);
		
		txtInsertBookId = new JTextField("Inset User Id");
		txtInsertBookId.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	txtInsertBookId.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	txtInsertBookId.setText("Insert Book Id");
		    }
		});
		springLayout.putConstraint(SpringLayout.SOUTH, txtInsertUserId, -27, SpringLayout.NORTH, txtInsertBookId);
		springLayout.putConstraint(SpringLayout.EAST, txtInsertUserId, 0, SpringLayout.EAST, txtInsertBookId);
		springLayout.putConstraint(SpringLayout.NORTH, txtInsertBookId, 129, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtInsertBookId, 21, SpringLayout.EAST, btnSearch_1);
		springLayout.putConstraint(SpringLayout.EAST, txtInsertBookId, 148, SpringLayout.EAST, btnSearch_1);
		getContentPane().add(txtInsertBookId);
		txtInsertBookId.setColumns(10);
		
		JButton btnBack_1 = new JButton("back");
		springLayout.putConstraint(SpringLayout.WEST, btnBack_1, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack_1, -10, SpringLayout.SOUTH, getContentPane());
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame=LibraryManagerGUI.getInstance();
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);
				
			}
		});
		getContentPane().add(btnBack_1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static ReportGui getInstance() 
	{
		
			if(INSTANCE2==null)
				INSTANCE2=new ReportGui();
		
				return INSTANCE2;
     }
	
	
}
