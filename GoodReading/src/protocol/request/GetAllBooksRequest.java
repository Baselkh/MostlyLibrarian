package protocol.request;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class GetAllBooksRequest implements Message {

	private String subjectID;
	
	public GetAllBooksRequest(String subjectID){
		this.subjectID= subjectID;
	}
	
	public String getSubjectID(){
		return subjectID;
	}
	
	public MessageType getMessageType() {
		return MessageType.GET_ALL_BOOKS_REQUEST;
	}
}
