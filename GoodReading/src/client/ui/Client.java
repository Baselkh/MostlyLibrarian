package client.ui;

import java.io.IOException;

import messages.Message;
//import com.mysql.jdbc.ResultSet;
import client.ocsf.AbstractClient;

public class Client extends AbstractClient {

	/**
	 * await response flag
	 */
	private boolean awaitResponse = false;
	/**
	 * response object
	 */
	private Object response;

	/**
	 * @param args
	 * @throws IOException
	 */

	public Client() throws IOException {
		super(); // Call the superclass constructor
	}

	public Client(String host, int port) throws IOException {
		super(host, port); // Call the superclass constructor
	}

	/**
	 * Connect to server
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	public boolean connect(String host, int port) {
		setHost(host);
		setPort(port);
		// here we create the controllers map and every time we need a specific
		// controller we create it
		try {
			openConnection();

			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Send Message to server
	 * 
	 * @param msg
	 * @return
	 */
	public Message sendMessage(Message msg) {
		try {
			awaitResponse = true;
			sendToServer(msg);
			// wait for response
			while (awaitResponse) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return (Message) response;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: Couldnt not send message to server");
			return null;
		}
	}

	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	/**
	 * Indicate response received
	 */
	@Override
	protected void handleMessageFromServer(Object msg) {
		awaitResponse = false;
		response = msg;

	}

}
