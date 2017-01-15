package message.handlers;

import messages.Message;
import protocol.request.SearchRequest;
import server.db.DBConnector;

public class SearchHandler extends AbstractRequestHandler{

	public SearchHandler(DBConnector dbCon) {
		super(dbCon);
		
	}

	@Override
	public Message handle(Message msg) {
		dbCon.booksearch(((SearchRequest) msg).getBook());
		return (Message) dbCon;
	}

}
