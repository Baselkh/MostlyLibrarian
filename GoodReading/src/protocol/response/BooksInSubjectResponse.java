package protocol.response;

import java.util.ArrayList;

import client.entities.Book;
import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class BooksInSubjectResponse implements Message {

	ArrayList<Book> books;
	
	public BooksInSubjectResponse(ArrayList<Book> books){
		this.books= books;
	}
	
	public ArrayList<Book> getBooks(){
		return books;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.BOOKS_IN_SUBJECT_RESPONSE;
	}
}
