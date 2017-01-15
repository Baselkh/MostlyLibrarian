package protocol.request;


import messages.Message;
import messages.MessageType;

public class ReportUserRequest implements Message   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String UserId;
	

	public ReportUserRequest(String userId) {
		super();
		UserId = userId;
	}

	@Override
	public MessageType getMessageType() {
		return MessageType.REPORTS_User_REQUEST;
	} 

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}
}//end ReportRequest class
