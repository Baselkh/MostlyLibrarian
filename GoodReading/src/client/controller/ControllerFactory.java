package client.controller;

import client.ui.Client;

/**
 * 
 * @author wardm
 *
 */
public class ControllerFactory {

	public static AbstractController create(ControllerType controllerType,
			Client client) {
		switch (controllerType) {
		// TODO: Add for each new Request
		case LOGIN_CONTROLLER:
			return new LoginController(client);
		case LIBRARY_MANAGER_CONTROLLER:
			return new LibraryManagerController(client);
		case SEARCH_BOOK_CONTROLLER:
			return new SearchController(client);
		case SEARCH_FEEDBACK_CONTROLLER:
			return new FeedbackController(client);
		case Report_CONTROLLER:
			return new ReportsController(client);
		case CATEGORY_CONTROLLER:
			return new CategoriesController(client);
		case SUBJECT_CONTROLLER:
			return new SubjectsController(client);
//		case REPORTS_CONTROLLER:
//			return new ReportsController(client);
//		case Report_CONTROLLER:
//			return new ReportsController(client);
		default:
			System.out.println("ERROR: Invalid handler type");
			return null;
		}
	}

}
