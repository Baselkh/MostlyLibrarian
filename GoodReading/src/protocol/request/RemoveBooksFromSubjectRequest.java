package protocol.request;

import java.util.ArrayList;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class RemoveBooksFromSubjectRequest implements Message {

	ArrayList<String> booksIDs;
	
	public RemoveBooksFromSubjectRequest(ArrayList<String> booksIDs){
		this.booksIDs= booksIDs;
	}
	
	public ArrayList<String> getBooksIDs(){
		return booksIDs;
	}
	
	public MessageType getMessageType() {
		return MessageType.REMOVE_BOOKS_REQUEST;
	}
}
