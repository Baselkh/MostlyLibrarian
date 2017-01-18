/**
 * 
 */
package message.handlers;

import messages.MessageType;
import server.db.DBConnector;

/**
 * 
 * @author bayan
 */
public class HandlerFactory {

	/**
	 * Factor for different handlers, and according the msgType parameter we determine witch handler that we want.
	 * 
	 * @param msgType that describe the message request.
	 * @param dbCon
	 * @return message kind of response 
	 */
	public static AbstractRequestHandler create(MessageType msgType,
			DBConnector dbCon) {
		switch (msgType) {
		// TODO: Add for each new Request
		case LOGIN_REQUEST:
			return new LoginRequestHandler(dbCon);
		case LOGOUT_REQUEST:
			return new LogoutRequestHandler(dbCon);
		case SEARCH_REQUEST:
			return new SearchHandler(dbCon);
		case ALL_CATEGORIES_REQUEST:
			return new GetAllCategoriesRequestHandler(dbCon);
		case SUBJECTS_IN_CATEGORY_REQUEST:
			return new SubjectsInCategoryRequestHandler(dbCon);
		case BOOKS_IN_SUBJECT_REQUEST:
			return new BooksInSubjectHandler(dbCon);
		case REMOVE_BOOKS_REQUEST:
			return new RemoveBooksFromSubjectRequestHandler(dbCon);
		case GET_BOOKS_NOT_IN_SUBJECT_REQUEST:
			return new GetBooksNotInSubjectRequestHandler(dbCon);
		case ADD_BOOKS_TO_SUBJECT_REQUEST:
			return new AddBooksToSubjectRequestHandler(dbCon);
		case ADD_SUBJECT_TO_CATEGORY_REQUEST:
			return new AddSubjectToCategoryRequestHandler(dbCon);
		case REMOVE_SUBJECT_FROM_CATEGORY_REQUEST:
			return new RemoveSubjectsFromCategoryRequestHandler(dbCon);
		case RENAME_SUBJECT_REQUEST:
			return new RenameSubjectRequestHandler(dbCon);
		case CREATE_NEW_CATEGORY_REQUEST:
			return new CreateNewCategoryRequestHandler(dbCon);
		case DELETE_CATEGORIES_REQUEST:
			return new DeleteCategoriesRequestHandler(dbCon);
		case RENAME_CATEGORY_REQUEST:
			return new RenameCategoryRequestHandler(dbCon);
		default:
			System.out.println("ERROR: Invalid handler type");
			return null;
		}
	}
}
