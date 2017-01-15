package client.controller;

import client.entities.Book;
import client.entities.User;
import client.ui.Client;
import protocol.request.LoginRequest;
import protocol.request.SearchRequest;
import protocol.response.LoginResponse;
import protocol.response.searchResponse;

public class SearchController extends AbstractController {

	public SearchController(Client client) {
		super(client);
		// TODO Auto-generated constructor stub
	}

	public searchResponse checkBookDetailsFromGUI(Book book){
		SearchRequest message = new SearchRequest(book);
		return (searchResponse) client.sendMessage(message);
	}
	
	/*public searchResponse SEARCHBOOKFromDB(Book b1) {
		//LoginRequest message = new BookRequest(b1);
		return (searchResponse) client.sendMessage(message);
	}// END*/
	
	/*public searchRequest checkSEARCHBOOKdetailsFromGUI(Book b1)
	{
		
	}*/
}
