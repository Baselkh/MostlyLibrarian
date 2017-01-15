package protocol.request;

import client.entities.Purchases;
import messages.Message;
import messages.MessageType;

public class FeedbackRequest  implements Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Purchases pur;
	
	
	public FeedbackRequest(Purchases pur) {
		this.pur=pur;
	}


	public Purchases getPur() {
		return pur;
	}

	public void setPur(Purchases pur) {
		this.pur = pur;
	}

	@Override
	public MessageType getMessageType() {
		return MessageType.FEEDBACK_REQUEST;
	}


}
