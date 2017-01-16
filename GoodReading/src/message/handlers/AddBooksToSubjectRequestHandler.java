package message.handlers;

import java.util.ArrayList;

import messages.Message;
import protocol.request.AddBooksToSubjectRequest;
import protocol.response.AddBooksToSubjectResponse;
import server.db.DBConnector;

public class AddBooksToSubjectRequestHandler extends AbstractRequestHandler {

	public AddBooksToSubjectRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		AddBooksToSubjectRequest message= (AddBooksToSubjectRequest) msg;
		
		String subjectID= message.getSubjectID();
		ArrayList<String> booksIDs= message.getBooksID();
		
		AddBooksToSubjectResponse response= new AddBooksToSubjectResponse(
				dbCon.addBooksToSubject(subjectID, booksIDs));
		return response;
	}
}
