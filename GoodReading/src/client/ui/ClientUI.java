package client.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GUI.Login;
import client.controller.Controllers;
import client.entities.Person;

import client.entities.User;


public class ClientUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2656001379728857124L;
	private JPanel contentPane;
	private JTextField serveradd;
	private JTextField port;
	JTextArea notification;
	public Client client;
	public static User currUser;
	public static String newPid;
//	public static LaboratoryReferral currLaboratoryReferral;
//	public static ArrayList<Portfolio> currPortfolios;
	

	/**
	 * Create the frame.
	 */
	public ClientUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 250);
		setTitle("Client");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblServerAddress = new JLabel("Server Address:");
		lblServerAddress.setBounds(10, 29, 140, 26);
		lblServerAddress.setForeground(Color.BLACK);
		lblServerAddress.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(lblServerAddress);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(10, 80, 51, 17);
		lblPort.setForeground(Color.BLACK);
		lblPort.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblPort);

		serveradd = new JTextField();
		serveradd.setBounds(153, 34, 124, 20);
		serveradd.setForeground(new Color(210, 105, 30));
		serveradd.setText("localhost");
		contentPane.add(serveradd);
		serveradd.setColumns(15);

		port = new JTextField();
		port.setBounds(153, 79, 124, 20);
		port.setForeground(new Color(210, 105, 30));
		port.setText("5555");
		contentPane.add(port);
		port.setColumns(10);

		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(10, 126, 89, 23);
		btnConnect.setFont(new Font("Arial", Font.PLAIN, 13));
		btnConnect.setForeground(Color.BLACK);
		btnConnect.setToolTipText("Connect to server");
		btnConnect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				boolean rc = client.connect(serveradd.getText(),
						Integer.valueOf(port.getText()));
				if (rc) {
					setNotification("Connection to server succeeded.");
					Login.getInstance();
					setUnvisible();

				} else {
					setNotification("Connection to server failed.");
					return;
				}
			}
		});
		contentPane.add(btnConnect);

		notification = new JTextArea();
		notification.setBounds(130, 123, 222, 26);
		notification.setForeground(new Color(210, 105, 30));
		notification.setEditable(false);
		contentPane.add(notification);

	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setNotification(String s) {
		notification.setText(s);
	}

	public void setUnvisible() {
		this.setVisible(false);
	}

	public static void main(String[] args) throws IOException {

		ClientUI clientui = new ClientUI();
		clientui.setVisible(true);
		Client client = new Client();
		Controllers.newInstance(client);
		clientui.setClient(client);

	}
}
