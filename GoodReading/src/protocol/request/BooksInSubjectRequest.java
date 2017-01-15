package protocol.request;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class BooksInSubjectRequest implements Message {

	private String subjectID;
	
	public BooksInSubjectRequest(String subjectID){
		this.subjectID= subjectID;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.BOOKS_IN_SUBJECT_REQUEST;
	}
	
	public String getSubjectID(){
		return subjectID;
	}
}
