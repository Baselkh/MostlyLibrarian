package message.handlers;

import messages.Message;
import protocol.request.BooksInSubjectRequest;
import protocol.request.RemoveBooksFromSubjectRequest;
import protocol.response.BooksInSubjectResponse;
import protocol.response.RemoveBooksFromSubjectResponse;
import server.db.DBConnector;

/**
 * @author Basel
 *
 */
public class RemoveBooksFromSubjectRequestHandler extends AbstractRequestHandler {

	public RemoveBooksFromSubjectRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		RemoveBooksFromSubjectRequest message= (RemoveBooksFromSubjectRequest) msg;
		RemoveBooksFromSubjectResponse response= new RemoveBooksFromSubjectResponse(dbCon.removeBooksFromSubject(message.getBooksIDs()));
		return response;
	}
}
