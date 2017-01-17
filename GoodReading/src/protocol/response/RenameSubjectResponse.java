package protocol.response;

import messages.Message;
import messages.MessageType;

public class RenameSubjectResponse implements Message {

	private boolean operationSuccessful;

	public RenameSubjectResponse(boolean operationSuccessful){
		this.operationSuccessful= operationSuccessful;
	}

	public boolean getOperationStatus(){
		return operationSuccessful;
	}

	public MessageType getMessageType() {
		return MessageType.RENAME_SUBJECT_RESPONSE;
	}
}
