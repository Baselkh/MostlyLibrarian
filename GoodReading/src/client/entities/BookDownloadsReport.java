package client.entities;

public class BookDownloadsReport {

	private String bookID;
	private String bookName;
	private long downloadsNumber;
	private int year;
	
	public BookDownloadsReport(String bookId,String bookName,long downloadsNumber,int year){
		this.bookID=bookId;
		this.bookName=bookName;
		this.year=year;
		this.downloadsNumber=downloadsNumber;
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

	public long getDownloadsNumber() {
		return downloadsNumber;
	}

	public void setDownloadsNumber(long downloadsNumber) {
		this.downloadsNumber = downloadsNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
