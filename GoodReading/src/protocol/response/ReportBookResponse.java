
package protocol.response;

import messages.Message;
import messages.MessageType;

public class ReportBookResponse implements Message {

	@Override
	public MessageType getMessageType() {
		return MessageType.REPORTS_Book_RESPONCE;
	}

}
