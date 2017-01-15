package protocol.response;

import java.util.ArrayList;

import client.entities.Purchases;
import messages.Message;
import messages.MessageType;

public class ReportUserResponse implements Message {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Purchases> purchases;

	
	public ReportUserResponse(ArrayList<Purchases> purchases) {
		super();
		this.purchases = purchases;
	}

	@Override
	public MessageType getMessageType() {
		// TODO Auto-generated method stub
		return MessageType.REPORTS_User_RESPONCE;
	}

	public ArrayList<Purchases> getPurchases() {
		return purchases;
	}

	public void setPurchases(ArrayList<Purchases> purchases) {
		this.purchases = purchases;
	}

}
