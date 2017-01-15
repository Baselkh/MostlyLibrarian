package protocol.response;

import client.entities.Purchases;
import messages.Message;
import messages.MessageType;

public class searchResponse implements Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private Purchases pur;
	public searchResponse(String text) {
		this.text = text;
	}

	@Override
	public MessageType getMessageType() {
		// TODO Auto-generated method stub
		return MessageType.SEARCH_RESPONSE;
	}

	public static searchResponse OK() {
		return new searchResponse("OK");
	}
	
	public static searchResponse NotFound() {
		return new searchResponse("Not Found");
	}

	public String getText() {
		return this.text;
	}

	public Purchases getPur() {
		return pur;
	}

	public void setPur(Purchases pur) {
		this.pur = pur;
	}
	/**
	 * This is a static method 
	 * @return Login Error response
	 */
	public static LoginResponse ERROR() {
		return new LoginResponse("ERROR!");
	}
	

}
