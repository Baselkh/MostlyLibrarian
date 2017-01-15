package message.handlers;

import java.sql.SQLException;
import java.util.ArrayList;

import messages.Message;
import protocol.request.LoginRequest;
import protocol.request.SubjectsInCategoryRequest;
import protocol.response.LoginResponse;
import protocol.response.SubjectsInCategoryResponse;
import server.db.DBConnector;

/**
 * @author Basel
 *
 */
public class SubjectsInCategoryRequestHandler extends AbstractRequestHandler {
	
	public SubjectsInCategoryRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		SubjectsInCategoryRequest message= (SubjectsInCategoryRequest) msg;
		String categoryName= message.getCategoryName();
		SubjectsInCategoryResponse response= dbCon.getSubjectsInCategory(categoryName);
		return response;
	}
}
