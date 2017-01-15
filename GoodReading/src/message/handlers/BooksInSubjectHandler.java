package message.handlers;

import messages.Message;
import protocol.request.BooksInSubjectRequest;
import protocol.request.GetAllCategoriesRequest;
import protocol.response.BooksInSubjectResponse;
import protocol.response.GetAllCategoriesResponse;
import server.db.DBConnector;

/**
 * @author Basel
 *
 */
public class BooksInSubjectHandler  extends AbstractRequestHandler {

	public BooksInSubjectHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		BooksInSubjectRequest message= (BooksInSubjectRequest) msg;
		BooksInSubjectResponse response= dbCon.getBooksInSubject(message.getSubjectID());
		return response;
	}
}
