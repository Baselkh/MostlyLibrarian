package protocol.request;

import messages.Message;
import messages.MessageType;

public class RenameSubjectRequest implements Message {

	private String subjectID;
	private String newSubjectName;
	
	public RenameSubjectRequest(String subjectID, String newSubjectName) {
		super();
		this.subjectID = subjectID;
		this.newSubjectName = newSubjectName;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public String getNewSubjectName() {
		return newSubjectName;
	}

	public MessageType getMessageType() {
		return MessageType.RENAME_SUBJECT_REQUEST;
	}
}
