package protocol.response;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class RemoveBooksFromSubjectResponse implements Message {

	private boolean operationSuccessful;
	
	public RemoveBooksFromSubjectResponse(boolean operationSuccessful) {
		this.operationSuccessful= operationSuccessful;
	}

	public boolean getOperationStatus(){
		return operationSuccessful;
	}
	
	public MessageType getMessageType() {
		return MessageType.REMOVE_BOOKS_RESPONSE;
	}
}
