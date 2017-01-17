package message.handlers;

import messages.Message;
import protocol.request.GetBooksNotInSubjectRequest;
import protocol.response.GetBooksNotInSubjectResponse;
import server.db.DBConnector;

/**
 * @author Basel
 *
 */
public class GetBooksNotInSubjectRequestHandler extends AbstractRequestHandler {

	public GetBooksNotInSubjectRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		GetBooksNotInSubjectRequest message= (GetBooksNotInSubjectRequest) msg;
		String subjectID= message.getSubjectID();
		GetBooksNotInSubjectResponse response= new GetBooksNotInSubjectResponse(dbCon.getBooksNotInSubject(subjectID));
		return response;
	}
}
