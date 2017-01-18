package protocol.request;

import java.util.ArrayList;

import messages.Message;
import messages.MessageType;

public class DeleteCategoriesRequest implements Message {

	private ArrayList<String> categories;
	
	public DeleteCategoriesRequest(ArrayList<String> categories) {
		this.categories = categories;
	}

	public ArrayList<String> getCategories(){
		return categories;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.DELETE_CATEGORIES_REQUEST;
	}
}
