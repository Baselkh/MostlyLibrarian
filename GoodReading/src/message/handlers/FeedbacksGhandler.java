package message.handlers;

import messages.Message;
import protocol.request.SearchRequest;
import protocol.response.searchResponse;
import server.db.DBConnector;


public class FeedbacksGhandler extends AbstractRequestHandler {

	public FeedbacksGhandler(DBConnector dbCon) {
		super(dbCon);
	}

	
	
	@Override
	public Message handle(Message msg) {
		int resp_case=((SearchRequest) msg).getPur().getSelect_case();
			if (dbCon.getFeildFromFeedback(((SearchRequest) msg).getPur(),resp_case) == false)
				return searchResponse.NotFound();
			else{
				searchResponse response = new searchResponse("OK");
				return response;
			}//end else
	}//end handle()
}