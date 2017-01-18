package messages;


/**
 * @author firas
 *This enum specifies the type of message includes the requests and the responses messages
 */
public enum MessageType {
	LOGIN_REQUEST,
	LOGIN_RESPONSE,
	LOGOUT_REQUEST,
	LOGOUT_RESPONSE,	
	FEEDBACK_REQUEST,
	FEEDBACK_RESPONSE,
	SEARCH_RESPONSE,
	SEARCH_REQUEST,
	REPORTS_User_REQUEST,
	REPORTS_User_RESPONCE,
	REPORTS_Book_REQUEST, 
	REPORTS_Book_RESPONCE,
	REPORTS_User_RESPONSE, 
	REPORTS_Book_RESPONSE,
	SUBJECTS_IN_CATEGORY_REQUEST,
	SUBJECTS_IN_CATEGORY_RESPONSE,
	ALL_CATEGORIES_REQUEST,
	ALL_CATEGORIES_RESPONSE,
	BOOKS_IN_SUBJECT_RESPONSE,
	BOOKS_IN_SUBJECT_REQUEST,
	REPORTS_RESPONSE,
	REPORTS_REQUEST,
	REMOVE_BOOKS_REQUEST,
	REMOVE_BOOKS_RESPONSE,
	GET_BOOKS_NOT_IN_SUBJECT_REQUEST,
	GET_BOOKS_NOT_IN_SUBJECT_RESPONSE,
	ADD_BOOKS_TO_SUBJECT_REQUEST,
	ADD_BOOKS_TO_SUBJECT_RESPONSE,
	ADD_SUBJECT_TO_CATEGORY_REQUEST,
	ADD_SUBJECT_TO_CATEGORY_RESPONSE,
	REMOVE_SUBJECT_FROM_CATEGORY_REQUEST,
	REMOVE_SUBJECT_FROM_CATEGORY_RESPONSE,
	RENAME_SUBJECT_REQUEST,
	RENAME_SUBJECT_RESPONSE,
	CREATE_NEW_CATEGORY_REQUEST,
	CREATE_NEW_CATEGORY_RESPONSE,
	DELETE_CATEGORIES_REQUEST,
	DELETE_CATEGORIES_RESPONSE,
	RENAME_CATEGORY_REQUEST,
	RENAME_CATEGORY_RESPONSE
}
