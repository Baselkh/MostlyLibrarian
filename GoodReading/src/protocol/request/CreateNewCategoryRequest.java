package protocol.request;

import messages.Message;
import messages.MessageType;

public class CreateNewCategoryRequest implements Message {

	private String categoryName;
	
	public CreateNewCategoryRequest(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return categoryName;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.CREATE_NEW_CATEGORY_REQUEST;
	}
}
