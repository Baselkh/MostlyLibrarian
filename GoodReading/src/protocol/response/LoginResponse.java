package protocol.response;

import messages.Message;
import messages.MessageType;
import client.entities.User;

/**
 * 
 * @author 
 *
 */
public class LoginResponse implements Message {
	
	private static final long serialVersionUID = -7973601750797747916L;
	private String text;
	private User user;

	@Override
	public MessageType getMessageType() {
		return MessageType.LOGIN_RESPONSE;
	}
	
	/**
	 * response message : This is about Login
	 * <p>
	 * This message includes appropriate String text response . 
	 *  
	 * @param appropriate response text
	 */
	public LoginResponse(String text) {
		this.text = text;
	}

	/**
	 * This is a static method 
	 * @return Login Successfully response
	 */
	public static LoginResponse OK() {
		return new LoginResponse("Login Successfull!");
	}

	/**
	 * This is a static method 
	 * @return User not found response
	 */
	public static LoginResponse NO_User() {
		return new LoginResponse("User not found!");
	}

	/**
	 * This is a static method 
	 * @return Login Error response
	 */
	public static LoginResponse ERROR() {
		return new LoginResponse("ERROR!");
	}

	/**
	 * This is a static method 
	 * @return Already Logged In response
	 */
	public static LoginResponse LOGGED_IN() {
		return new LoginResponse("Already Logged In!");
	}
	
	/**
	 * This is a static method 
	 * @return Wrong password response
	 */
	public static LoginResponse WRONG_PASSWORD() {
		return new LoginResponse("Wrong Password!");
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
