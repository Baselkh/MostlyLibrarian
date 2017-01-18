package message.handlers;

import messages.Message;
import protocol.request.RemoveSubjectsFromCategoryRequest;
import protocol.request.RenameCategoryRequest;
import protocol.response.RemoveSubjectsFromCategoryResponse;
import protocol.response.RenameCategoryResponse;
import server.db.DBConnector;

/**
 * @author Basel
 *
 */
public class RenameCategoryRequestHandler extends AbstractRequestHandler {

	public RenameCategoryRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		RenameCategoryRequest message= (RenameCategoryRequest) msg;
		RenameCategoryResponse response= new RenameCategoryResponse(
				dbCon.renameCategory(message.getOldName(), message.getNewName()));
		return response;
	}
}
