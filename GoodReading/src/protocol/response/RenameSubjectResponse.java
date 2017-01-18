package protocol.response;

import messages.Message;
import messages.MessageType;

public class RenameSubjectResponse implements Message {

	private boolean operationStatus;
	private String categoryName;

	public RenameSubjectResponse(boolean operationStatus, String categoryName){
		this.operationStatus= operationStatus;
		this.categoryName = categoryName;
	}

	public boolean getOperationStatus(){
		return operationStatus;
	}
	
	public String getCategoryName(){
		return categoryName;
	}

	public MessageType getMessageType() {
		return MessageType.RENAME_SUBJECT_RESPONSE;
	}
}
