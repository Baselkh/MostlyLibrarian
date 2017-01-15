package client.controller;

import client.ui.Client;

public class ReportsController extends AbstractController {
	

	public ReportsController(Client cl){
		super(cl);
	}
	
	public enum report{BOOK_SEARCHES_REPORT, BOOK_DOWNLOADS_REPORT}
	
	public void viewUserReport(String userID){}
	
	
	public void viewBookReport(String bookID){}
	
	
}
