package protocol.response;

import java.util.ArrayList;

import client.entities.Book;
import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class GetBooksNotInSubjectResponse implements Message {

	private ArrayList<Book> books;
	
	public GetBooksNotInSubjectResponse(ArrayList<Book> books){
		this.books= books;
	}
	
	public ArrayList<Book> getBooks(){
		return books;
	}
	
	public MessageType getMessageType() {
		return MessageType.GET_BOOKS_NOT_IN_SUBJECT_RESPONSE;
	}
}
