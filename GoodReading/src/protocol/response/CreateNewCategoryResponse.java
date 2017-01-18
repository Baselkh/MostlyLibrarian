package protocol.response;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class CreateNewCategoryResponse implements Message {
	
	private boolean operationStatus;
	
	public CreateNewCategoryResponse(boolean operationStatus) {
		this.operationStatus = operationStatus;
	}

	public boolean getOperationStatus() {
		return operationStatus;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.CREATE_NEW_CATEGORY_RESPONSE;
	}
}
