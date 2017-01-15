package protocol.request;

import java.util.ArrayList;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class SubjectsInCategoryRequest implements Message {

	private String categoryName;

	public SubjectsInCategoryRequest(String categoryName){
		this.categoryName= categoryName;
	}
	
	public String getCategoryName(){
		return categoryName;
	}
	
	public MessageType getMessageType() {
		return MessageType.SUBJECTS_IN_CATEGORY_REQUEST;
	}
}
