package protocol.response;

import java.util.ArrayList;

import messages.Message;
import messages.MessageType;

public class RemoveSubjectsFromCategoryResponse implements Message {

	private boolean operationSuccessful;
	
	public RemoveSubjectsFromCategoryResponse(boolean operationSuccessful){
		this.operationSuccessful= operationSuccessful;
	}
	
	public boolean getOperationStatus(){
		return operationSuccessful;
	}
	
	public MessageType getMessageType() {
		return MessageType.REMOVE_SUBJECT_FROM_CATEGORY_RESPONSE;
	}
}
