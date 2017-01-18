package message.handlers;

import messages.Message;
import protocol.request.DeleteCategoriesRequest;
import protocol.response.DeleteCategoriesResponse;
import server.db.DBConnector;

public class DeleteCategoriesRequestHandler extends AbstractRequestHandler {

	public DeleteCategoriesRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		DeleteCategoriesRequest message= (DeleteCategoriesRequest) msg;
		DeleteCategoriesResponse response= new DeleteCategoriesResponse
				(dbCon.deleteCategories(message.getCategories()));
		return response;
	}
}
