package client.entities;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JTextField;
 
public class Book implements Serializable {
	private String bookID;
	private String Title;
	private String Language;
	private String Summary;
	private String tableOfContents;
	// May be unnecessary
	private ArrayList<String> SearchResult;
	private String downloadsNum;
	private String Keywords;
	private String Authors;
	public int num=0;
	
	
	public Book(String bookID,String Title,String Language,String Summary,String tableOfContents,String downloadsNum,String Keywords,String authors){
		this.bookID=bookID;
		this.Title=Title;
		this.Language=Language;
		this.Summary=Summary;
		this.tableOfContents=tableOfContents;
		this.downloadsNum=downloadsNum;
		this.Keywords=Keywords;
		this.Authors= authors;
	}
	public Book(String bookID,String Name,String Language,String Authors)
	{
		this.bookID=bookID;
		this.Title=Title;
		this.Language=Language;
		this.Authors=Authors;
	}
	
	
	public enum Format {
	    pdf,doc,fb2
	}
	
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	public String getTableOfContents() {
		return tableOfContents;
	}
	public void setTableOfContents(String tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	public String getAuthors() {
		return Authors;
	}
	
	public void  createArrayList()
	{
		SearchResult= new ArrayList<String>();
		
	}
	
	public String getDownloadsNumber(){
		String str;
		return (str= ""+downloadsNum);
	}
	
	public String getKeywords(){
		return Keywords;
	}
	
	public void fillArrayList(String bookID,String Title,String Language,String Summary,String tableOfContents,String downloadsNum,String Keywords,String author)
	{
		SearchResult.add(bookID);
		SearchResult.add(Title);
		SearchResult.add(Language);
		SearchResult.add(Summary);
		SearchResult.add(tableOfContents);
		SearchResult.add(downloadsNum);
		SearchResult.add(Keywords);
		SearchResult.add(author);
		num++;
	}
	
	
	
}