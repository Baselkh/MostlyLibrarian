package message.handlers;

import messages.Message;
import protocol.request.RenameSubjectRequest;
import protocol.response.RenameSubjectResponse;
import server.db.DBConnector;

public class RenameSubjectRequestHandler extends AbstractRequestHandler {

	public RenameSubjectRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		RenameSubjectRequest message= (RenameSubjectRequest) msg;
		RenameSubjectResponse response= new 
				RenameSubjectResponse(dbCon.renameSubject(message.getSubjectID(),
						message.getNewSubjectName()));
		return response;
	}
}
