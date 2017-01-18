package protocol.response;

import messages.Message;
import messages.MessageType;

public class DeleteCategoriesResponse implements Message {

private boolean operationStatus;
	
	public DeleteCategoriesResponse(boolean operationStatus) {
		this.operationStatus = operationStatus;
	}

	public boolean getOperationStatus() {
		return operationStatus;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.DELETE_CATEGORIES_RESPONSE;
	}
}
