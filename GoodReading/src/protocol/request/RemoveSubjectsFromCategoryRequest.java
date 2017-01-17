package protocol.request;

import java.util.ArrayList;

import messages.Message;
import messages.MessageType;

public class RemoveSubjectsFromCategoryRequest implements Message {

	private ArrayList<String> subjectsIDs;
	private String categoryName;
	
	public RemoveSubjectsFromCategoryRequest(ArrayList<String> subjectsIDs, String categoryName) {
		this.subjectsIDs = subjectsIDs;
		this.categoryName = categoryName;
	}

	public ArrayList<String> getSubjectsIDs(){
		return subjectsIDs;
	}

	public String getCategoryName(){
		return categoryName;
	}
	
	public MessageType getMessageType() {
		return MessageType.REMOVE_SUBJECT_FROM_CATEGORY_REQUEST;
	}
}
