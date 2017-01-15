package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentOptionGUI extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static PaymentOptionGUI INSTANCE2=null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PaymentOptionGUI() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnOk = new JButton("OK");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOk, -134, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnOk, 154, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnOk, -111, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOk, 212, SpringLayout.WEST, contentPane);
		contentPane.add(btnOk);
		
		JRadioButton rdbtnTashlomMeyade = new JRadioButton("TASHLOM MEYADE");
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnTashlomMeyade, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnTashlomMeyade, 10, SpringLayout.WEST, contentPane);
		contentPane.add(rdbtnTashlomMeyade);
		
		JRadioButton rdbtnTashlomodshe = new JRadioButton("TASHLOM 7ODSHE");
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnTashlomodshe, 6, SpringLayout.SOUTH, rdbtnTashlomMeyade);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnTashlomodshe, 0, SpringLayout.WEST, rdbtnTashlomMeyade);
		contentPane.add(rdbtnTashlomodshe);
		
		JRadioButton rdbtnTashlomShnte = new JRadioButton("TASHLOM SHNTE");
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnTashlomShnte, 6, SpringLayout.SOUTH, rdbtnTashlomodshe);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnTashlomShnte, 10, SpringLayout.WEST, contentPane);
		contentPane.add(rdbtnTashlomShnte);
		
		JButton btnBack = new JButton("back->");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame=DownloadOptionGUI.getInstance();
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBack, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnBack);
	}
	public static PaymentOptionGUI getInstance() 
	{
		
			if(INSTANCE2==null)
				INSTANCE2=new PaymentOptionGUI();
		
				return INSTANCE2;
     }
}
