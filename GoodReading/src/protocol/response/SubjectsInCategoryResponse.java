package protocol.response;

import java.util.ArrayList;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class SubjectsInCategoryResponse implements Message {

	private ArrayList<String> subjectsIDs;
	private ArrayList<String> subjectsNames;
	
	public SubjectsInCategoryResponse(ArrayList<String> subjectsIDs, ArrayList<String> subjectsNames){
		this.subjectsIDs= subjectsIDs;
		this.subjectsNames= subjectsNames;
	}
	
	public ArrayList<String> getSubjectsIDs() {
		return subjectsIDs;
	}
	
	public ArrayList<String> getSubjectsNames() {
		return subjectsNames;
	}
	
	public MessageType getMessageType() {
		return MessageType.SUBJECTS_IN_CATEGORY_RESPONSE;
	}
}
