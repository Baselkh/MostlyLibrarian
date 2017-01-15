package protocol.response;

import client.entities.Purchases;
import messages.Message;
import messages.MessageType;

public class FeedbackResponse implements Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Purchases pur;
	private String text;

	public FeedbackResponse(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MessageType getMessageType() {
		return MessageType.FEEDBACK_RESPONSE;
	}
	
	public static FeedbackResponse NOTFOUND() {
		return new FeedbackResponse("NOT FOUND!");
	}
	public static FeedbackResponse FOUND() {	
		return new FeedbackResponse("FOUND");
	}
	
	public Purchases getPur() {
		return pur;
	}

	public void setPur(Purchases pur) {
		this.pur = pur;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
