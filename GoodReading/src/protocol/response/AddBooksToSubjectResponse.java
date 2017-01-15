package protocol.response;

import messages.Message;
import messages.MessageType;

public class AddBooksToSubjectResponse implements Message {

	private boolean operationStatus;
	
	
	
	public AddBooksToSubjectResponse(boolean operationStatus) {
		super();
		this.operationStatus = operationStatus;
	}

	public boolean operationIsSuccessful() {
		return operationStatus;
	}

	public MessageType getMessageType() {
		return MessageType.ADD_BOOKS_TO_SUBJECT_RESPONSE;
	}
}
