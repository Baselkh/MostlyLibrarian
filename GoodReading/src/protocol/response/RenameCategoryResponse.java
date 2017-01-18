package protocol.response;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class RenameCategoryResponse implements Message {

private boolean operationStatus;
	
	public RenameCategoryResponse(boolean operationStatus) {
		this.operationStatus = operationStatus;
	}

	public boolean getOperationStatus() {
		return operationStatus;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.RENAME_CATEGORY_RESPONSE;
	}
}
