package protocol.response;

import java.util.ArrayList;

import client.entities.Book;
import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class GetAllBooksResponse implements Message {

	private ArrayList<Book> books;
	
	public GetAllBooksResponse(ArrayList<Book> books){
		this.books= books;
	}
	
	public ArrayList<Book> getBooks(){
		return books;
	}
	
	public MessageType getMessageType() {
		return MessageType.GET_ALL_BOOKS_RESPONSE;
	}
}
