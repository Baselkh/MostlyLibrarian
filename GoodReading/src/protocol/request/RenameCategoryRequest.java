package protocol.request;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class RenameCategoryRequest implements Message {

	private String oldName;
	private String newName;
	
	public RenameCategoryRequest(String oldName, String newName) {
		super();
		this.oldName = oldName;
		this.newName = newName;
	}

	public String getOldName() {
		return oldName;
	}

	public String getNewName() {
		return newName;
	}

	@Override
	public MessageType getMessageType() {
		return MessageType.RENAME_CATEGORY_REQUEST;
	}
}
