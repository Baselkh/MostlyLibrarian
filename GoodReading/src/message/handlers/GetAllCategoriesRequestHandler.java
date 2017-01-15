package message.handlers;

import messages.Message;
import protocol.request.GetAllCategoriesRequest;
import protocol.request.SubjectsInCategoryRequest;
import protocol.response.GetAllCategoriesResponse;
import protocol.response.SubjectsInCategoryResponse;
import server.db.DBConnector;

/**
 * @author Basel
 *
 */
public class GetAllCategoriesRequestHandler extends AbstractRequestHandler {

	public GetAllCategoriesRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		GetAllCategoriesRequest message= (GetAllCategoriesRequest) msg;
		GetAllCategoriesResponse response= new 
				GetAllCategoriesResponse(dbCon.getAllCategories());
		return response;
	}
}
