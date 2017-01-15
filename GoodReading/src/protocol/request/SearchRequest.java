package protocol.request;

import client.entities.Book;
import client.entities.Purchases;
import client.entities.User;
import messages.Message;
import messages.MessageType;

public class SearchRequest implements Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	private Purchases pur;
	public SearchRequest(Book book) {
		this.book=book;
	}
	
	public SearchRequest(Purchases pur) {
		this.pur=pur;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Purchases getPur() {
		return pur;
	}

	public void setPur(Purchases pur) {
		this.pur = pur;
	}
	
	@Override
	public MessageType getMessageType() {
		
		return MessageType.SEARCH_REQUEST;
	}
}
