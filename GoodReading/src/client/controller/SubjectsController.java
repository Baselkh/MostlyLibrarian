package client.controller;

import java.util.ArrayList;

import client.ui.Client;
import protocol.request.AddBooksToSubjectRequest;
import protocol.request.BooksInSubjectRequest;
import protocol.request.GetBooksNotInSubjectRequest;
import protocol.request.RemoveBooksFromSubjectRequest;
import protocol.response.AddBooksToSubjectResponse;
import protocol.response.BooksInSubjectResponse;
import protocol.response.GetBooksNotInSubjectResponse;
import protocol.response.RemoveBooksFromSubjectResponse;

public class SubjectsController extends AbstractController {

	public SubjectsController(Client client){
		super(client);
	}
	
	public BooksInSubjectResponse getBooksInSubject(String subjectID){
		BooksInSubjectRequest message= new BooksInSubjectRequest(subjectID);
		return (BooksInSubjectResponse) client.sendMessage(message);
	}
	
	public RemoveBooksFromSubjectResponse removeBooksFromSubject(ArrayList<String> booksIDs){
		RemoveBooksFromSubjectRequest message= new RemoveBooksFromSubjectRequest(booksIDs);
		return (RemoveBooksFromSubjectResponse) client.sendMessage(message);
	}
	
	public GetBooksNotInSubjectResponse getBooksNotInSubject(String subjectID){
		GetBooksNotInSubjectRequest message= new GetBooksNotInSubjectRequest(subjectID);
		return (GetBooksNotInSubjectResponse) client.sendMessage(message);
	}
	
	public AddBooksToSubjectResponse addBooksToSubject(String subjectID, ArrayList<String> booksIDs){
		AddBooksToSubjectRequest message= new AddBooksToSubjectRequest(subjectID, booksIDs);
		return (AddBooksToSubjectResponse) client.sendMessage(message);
	}
}

