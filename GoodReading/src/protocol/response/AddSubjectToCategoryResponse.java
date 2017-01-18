package protocol.response;

import messages.Message;
import messages.MessageType;

public class AddSubjectToCategoryResponse implements Message {

	private boolean operationStatus;
	
	public AddSubjectToCategoryResponse(boolean operationStatus) {
		super();
		this.operationStatus = operationStatus;
	}

	public boolean getOperationStatus() {
		return operationStatus;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.ADD_SUBJECT_TO_CATEGORY_RESPONSE;
	}
}
