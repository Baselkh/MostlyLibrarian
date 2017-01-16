package protocol.request;

import messages.Message;
import messages.MessageType;

public class AddSubjectToCategoryRequest implements Message {

	private String categoryName;
	private String subjectName;
	
	public AddSubjectToCategoryRequest(String categoryName, String subjectName){
		this.categoryName= categoryName;
		this.subjectName= subjectName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	@Override
	public MessageType getMessageType() {
		return MessageType.ADD_SUBJECT_TO_CATEGORY_REQUEST;
	}
}
