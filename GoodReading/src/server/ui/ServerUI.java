package server.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 * 
 * @author wardm
 *
 */
public class ServerUI extends JFrame {

	private static final long serialVersionUID = -4141772994391133469L;
	private JPanel contentPane;
	private JTextArea serverConsole;
	private JLabel lblDbName;
	private JTextField textFieldDBName;
	private JLabel lblPort;
	private JTextField textFieldPort;
	private JButton btnConnect;
	private JTextField textFieldUser;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JPasswordField textFieldPass;
	Server server;
	private JLabel lblNewLabel;
	public static int imgNum=0;
	

	/**
	 * this class is used to show a window on the server<p>
	 * it contains the main for the server
	 */
	public ServerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setTitle("Server");
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1,
				(Color) Color.WHITE));
		scrollPane.setBounds(78, 218, 334, 122);
		contentPane.add(scrollPane);

		serverConsole = new JTextArea();
		scrollPane.setViewportView(serverConsole);
		serverConsole.setEditable(false);

		lblDbName = new JLabel("DB Name:");
		lblDbName.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDbName.setBounds(60, 34, 86, 14);
		contentPane.add(lblDbName);

		textFieldDBName = new JTextField();
		textFieldDBName.setForeground(new Color(139, 0, 0));
		textFieldDBName.setFont(new Font("Palatino Linotype", Font.BOLD
				| Font.ITALIC, 13));
		textFieldDBName.setBounds(171, 34, 186, 20);
		textFieldDBName.setText("good_reading");
		contentPane.add(textFieldDBName);
		textFieldDBName.setColumns(10);

		lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPort.setBounds(60, 67, 64, 14);
		contentPane.add(lblPort);

		textFieldPort = new JTextField();
		textFieldPort.setFont(new Font("Palatino Linotype", Font.BOLD
				| Font.ITALIC, 12));
		textFieldPort.setForeground(new Color(165, 42, 42));
		textFieldPort.setBounds(171, 67, 186, 20);
		textFieldPort.setText("5555");
		contentPane.add(textFieldPort);
		textFieldPort.setColumns(10);

		btnConnect = new JButton("Connect");
		btnConnect.setFont(new Font("Arial", Font.PLAIN, 13));
		btnConnect.setBounds(58, 184, 113, 23);
		btnConnect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Set Server Port
				server.setPort(Integer.valueOf(textFieldPort.getText()));
				// Connect to DB
				boolean rc = server.connectToDB(textFieldDBName.getText(),
						textFieldUser.getText(),
						new String(textFieldPass.getPassword()));

				if (rc) {
					display("SQL connection succeed");
				} else {
					display("SQL connection failed.");
					return;
				}

				try {
					server.listen(); // Start listening for connections
					display("Server is listening on port "
							+ textFieldPort.getText());
				} catch (Exception e1) {
					display("ERROR - Could not listen for clients!");
				}
			}
		});
		contentPane.add(btnConnect);

		textFieldUser = new JTextField();
		textFieldUser.setForeground(new Color(165, 42, 42));
		textFieldUser.setFont(new Font("Palatino Linotype", Font.BOLD
				| Font.ITALIC, 13));
		textFieldUser.setBounds(171, 98, 186, 20);
		textFieldUser.setText("root");
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);

		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsername.setBounds(60, 98, 101, 14);
		contentPane.add(lblUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPassword.setBounds(60, 133, 101, 14);
		contentPane.add(lblPassword);

		textFieldPass = new JPasswordField();
		textFieldPass.setForeground(new Color(165, 42, 42));
		textFieldPass.setFont(new Font("Palatino Linotype", Font.BOLD
				| Font.ITALIC, 13));
		textFieldPass.setBounds(171, 133, 186, 20);
		textFieldPass.setText("Braude");
		contentPane.add(textFieldPass);
		textFieldPass.setColumns(10);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(165, 42, 42));
		// lblNewLabel.setIcon(new
		// ImageIcon("C:\\Users\\302496419\\Desktop\\check\\Prototype\\rsz_red-wallpapers.jpg"));
		lblNewLabel.setBounds(0, 0, 584, 462);
		contentPane.add(lblNewLabel);
	}
	/**
	 * display another string on the screen
	 * @param s
	 */
	public void display(String s) {
		serverConsole.append(s + "\n");
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public static void main(String[] args) {

		ServerUI serverui = new ServerUI();
		Server server = new Server(serverui);
		serverui.setServer(server);
	}
}