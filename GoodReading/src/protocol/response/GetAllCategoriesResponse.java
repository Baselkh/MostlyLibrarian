package protocol.response;

import java.util.ArrayList;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class GetAllCategoriesResponse implements Message {

	private ArrayList<String> categoriesNames;
	
	public GetAllCategoriesResponse(ArrayList<String> categoriesNames){
		this.categoriesNames= categoriesNames;
	}
	
	public ArrayList<String> getCategoriesNames(){
		return categoriesNames;
	}
	
	public MessageType getMessageType() {
		return MessageType.ALL_CATEGORIES_RESPONSE;
	}
}
