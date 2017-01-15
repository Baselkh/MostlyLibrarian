package client.controller;

import client.entities.Purchases;
import client.ui.Client;
import protocol.request.FeedbackRequest;
import protocol.response.FeedbackResponse;

public class FeedbackController extends AbstractController{

	public FeedbackController(Client client) {
		super(client);
		
	}
	
	public FeedbackResponse selectfieldFromGUI(Purchases pur,int num) {
		FeedbackRequest message = new FeedbackRequest(pur);
		return (FeedbackResponse) client.sendMessage(message);
	}// END




}
