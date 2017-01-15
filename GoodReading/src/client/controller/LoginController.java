package client.controller;

import protocol.request.LoginRequest;
import protocol.request.LogoutRequest;
import protocol.response.LoginResponse;
import protocol.response.LogoutResponse;
import client.entities.User;
import client.ui.Client;
/**
 * 
 * @author ψεπο
 * LoginController This is an LoginController class that control all
 * the request related laboratory
 */
public class LoginController extends AbstractController {

	/**
	 * This is the constructor for this class
	 */
	public LoginController(Client client) {
		super(client);
	}

	/**
	 * This method send request message by
	 *            the client to the server to Check Login Details in the
	 *            database and return an appropriate response message
	 *
	 * @param user
	 * @return appropriate LoginResponse 
	 */
	public LoginResponse checkLoginDetailsFromGUI(User user) {
		LoginRequest message = new LoginRequest(user);
		return (LoginResponse) client.sendMessage(message);
	}// END

	/**
	 * This method send request message by the client to the server
	 * to log out and return appropriate response message 
	 * 
	 * @param user
	 * @return appropriate LogoutResponse
	 */
	public LogoutResponse logoutUser(User user) {
		LogoutRequest message = new LogoutRequest(user);
		return (LogoutResponse) client.sendMessage(message);
	}
	
}
