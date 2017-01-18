package message.handlers;

import messages.Message;
import protocol.request.CreateNewCategoryRequest;
import protocol.response.CreateNewCategoryResponse;
import server.db.DBConnector;

public class CreateNewCategoryRequestHandler extends AbstractRequestHandler {

	public CreateNewCategoryRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		CreateNewCategoryRequest message= (CreateNewCategoryRequest) msg;
		CreateNewCategoryResponse response= new CreateNewCategoryResponse
				(dbCon.createNewCategory(message.getCategoryName()));
		return response;
	}
}
