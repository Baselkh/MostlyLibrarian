package protocol.request;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class GetAllCategoriesRequest implements Message {

	public MessageType getMessageType() {
		return MessageType.ALL_CATEGORIES_REQUEST;
	}
}
