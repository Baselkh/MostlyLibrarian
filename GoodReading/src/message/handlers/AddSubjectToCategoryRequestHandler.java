package message.handlers;

import java.util.ArrayList;

import messages.Message;
import protocol.request.AddBooksToSubjectRequest;
import protocol.request.AddSubjectToCategoryRequest;
import protocol.response.AddBooksToSubjectResponse;
import protocol.response.AddSubjectToCategoryResponse;
import server.db.DBConnector;

public class AddSubjectToCategoryRequestHandler extends AbstractRequestHandler {

	public AddSubjectToCategoryRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {
		AddSubjectToCategoryRequest message= (AddSubjectToCategoryRequest) msg;
		
		String categoryName= message.getCategoryName();
		String subjectName= message.getSubjectName();
		
		AddSubjectToCategoryResponse response= new AddSubjectToCategoryResponse(
				dbCon.addSubjectToCategory(categoryName, subjectName));
		return response;
	}
}
