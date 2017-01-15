package protocol.request;

import client.entities.User;
import messages.Message;
import messages.MessageType;

public class LoginRequest implements Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7228862891624675294L;
	/**
	 * 
	 */
	private User user;

	public LoginRequest(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see messages.Message#getMessageType()
	 */
	@Override
	public MessageType getMessageType() {
		return MessageType.LOGIN_REQUEST;
	}

	

}