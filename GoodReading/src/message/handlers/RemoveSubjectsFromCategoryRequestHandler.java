package message.handlers;

import messages.Message;
import protocol.request.RemoveSubjectsFromCategoryRequest;
import protocol.response.RemoveSubjectsFromCategoryResponse;
import server.db.DBConnector;

public class RemoveSubjectsFromCategoryRequestHandler extends AbstractRequestHandler {
	
	public RemoveSubjectsFromCategoryRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		RemoveSubjectsFromCategoryRequest message= (RemoveSubjectsFromCategoryRequest) msg;
		RemoveSubjectsFromCategoryResponse response= new RemoveSubjectsFromCategoryResponse(
				dbCon.removeSubjectsFromCategory(message.getSubjectsIDs(), message.getCategoryName()));
		return response;
	}
}
