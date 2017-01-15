package client.controller;

import client.entities.Subject;
import client.ui.Client;
import protocol.request.BooksInSubjectRequest;
import protocol.response.BooksInSubjectResponse;
import protocol.response.GetAllCategoriesResponse;

public class SubjectsController extends AbstractController {

	public SubjectsController(Client client){
		super(client);
	}
	
	public BooksInSubjectResponse getBooksInSubject(String subjectID){
		BooksInSubjectRequest message= new BooksInSubjectRequest(subjectID);
		return (BooksInSubjectResponse) client.sendMessage(message);
	}
}

