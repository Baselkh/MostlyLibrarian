package protocol.request;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class GetBooksNotInSubjectRequest implements Message {

	private String subjectID;
	
	public GetBooksNotInSubjectRequest(String subjectID){
		this.subjectID= subjectID;
	}
	
	public String getSubjectID(){
		return subjectID;
	}
	
	public MessageType getMessageType() {
		return MessageType.GET_BOOKS_NOT_IN_SUBJECT_REQUEST;
	}
}
