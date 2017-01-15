package client.entities;

public class BookSearchesReport {
	private String bookID;
	private String bookName;
	private long searchesNumber;
	private int year;
	
	public BookSearchesReport(String bookID,String bookName,long searchesNumber,int year){
		this.bookID=bookID;
		this.bookName=bookName;
		this.year=year;
		this.searchesNumber=searchesNumber;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public long getSearchesNumber() {
		return searchesNumber;
	}

	public void setSearchesNumber(long searchesNumber) {
		this.searchesNumber = searchesNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	

}
