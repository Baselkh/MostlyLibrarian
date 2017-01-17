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
	//	case SEARCH_Feedback_REQUEST:
	// new FeedbacksGhandler(dbCon);
//		case LABORATORYREFERRAL_REQUEST:
//			return new LaboratoryReferralRequestHandler(dbCon);
//		case ENTERTESTRESULT_REQUEST:
//			return new EnterTestResultRequestHandler(dbCon);
//		case DOCTORTYPES_REQUEST:
//			return new DoctorTypesRequestHandler(dbCon);
//		case DOCTORNAMES_REQUEST:
//			return new DoctorNamesRequestHandler(dbCon);
//		case APPOINTMENTDATETIME_REQUEST:
//			return new AppointmentDateTimeRequestHandler(dbCon);
//		case MAKEAPPOINTMENT_REQUEST:
//			return new MakeAppointmentRequestHandler(dbCon);
//		case GETAPPOINTMENTS_REQUEST:
//			return new GetAppointmentsRequestHandler(dbCon);
//		case DELETEAPPOINTMENT_REQUEST:
//			return new DeleteAppointmentRequestHandler(dbCon);
//		case DIAGNOSTICHISTORY_REQUEST:
//			return new DiagnosticHistoryRequestHandler(dbCon);
//		case TREATMENTHISTORY_REQUEST:
//			return new TreatmentHistoryRequestHandler(dbCon);
//		case VIEWTESTRESULT_REQUEST:
//			return new ViewTestResultRequestHandler(dbCon);
//		case PORTFOLIO_REQUEST:
//			return new PortfolioRequestHandler(dbCon);
//		case DOCUMENTATION_REQUEST:
//			return new DocumintationRequestHandler(dbCon);
//		case GETALLAPPOINTMENTS_REQUEST:
//			return new GetAllAppointmentsRequestHandler(dbCon);
//		case LABTYPE_REQUEST:
//			return new LabTypesRequestHandler(dbCon);		
//		case LABADDRESS_REQUEST:
//			return new LabAddressRequestHandler(dbCon);
//		case LABDATETIME_REQUEST:
//			return new LabDateTimeRequestHandler(dbCon);
//		case GENERATEAREFFERAL_REQUEST:
//			return new GenerateARefferalRequestHandler(dbCon);	
//		case MAILSENDED_REQUEST:
//			return new MailSendedRequestHandler(dbCon);		
//		case WEEKLYREPORT_REQUEST:
//			return new WeeklyReportRequestHandler(dbCon);
//		case MONTHLYREPORT_REQUEST:
//			return new MonthlyReportRequestHandler(dbCon);
//		case GETALLCLINICS_REQUEST:
//			return new GetAllClinicsRequestHandler(dbCon);
//		case REPORTSCOLLECTION_REQUEST:
//			return new ReportCollectionRequestHandler(dbCon);
		default:
			System.out.println("ERROR: Invalid handler type");
			return null;
		}
	}
}
