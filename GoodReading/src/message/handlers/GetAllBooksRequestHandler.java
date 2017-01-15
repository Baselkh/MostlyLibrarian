package message.handlers;

import messages.Message;
import protocol.request.GetAllBooksRequest;
import protocol.response.GetAllBooksResponse;
import server.db.DBConnector;

/**
 * @author Basel
 *
 */
public class GetAllBooksRequestHandler extends AbstractRequestHandler {

	public GetAllBooksRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		GetAllBooksRequest message= (GetAllBooksRequest) msg;
		String subjectID= message.getSubjectID();
		GetAllBooksResponse response= new GetAllBooksResponse(dbCon.getAllBooks(subjectID));
		return response;
	}
}
