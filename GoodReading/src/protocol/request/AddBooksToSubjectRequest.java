package protocol.request;

import java.util.ArrayList;

import messages.Message;
import messages.MessageType;

public class AddBooksToSubjectRequest implements Message {

	private String subjectID;
	private ArrayList<String> booksID;
	
	public AddBooksToSubjectRequest(String subjectID, ArrayList<String> booksID){
		this.subjectID= subjectID;
		this.booksID= booksID;
	}
	
	public String getSubjectID() {
		return subjectID;
	}

	public ArrayList<String> getBooksID() {
		return booksID;
	}

	public MessageType getMessageType() {
		return MessageType.ADD_BOOKS_TO_SUBJECT_REQUEST;
	}
}
