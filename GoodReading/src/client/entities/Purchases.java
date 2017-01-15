package client.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * @author Basel
 *
 */
public class Purchases implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bookID;
	private String userName;
	private String feedbackTitle;
	private int select_case;
	private String feedbackText;
	private LocalDate feedbackDate;
	private ArrayList<String> keywords;
	private String signature;
	private String Author;
	private String Title;
	
	public Purchases(String bookID, String userName, String feedbackTitle,
			String feedbackText, LocalDate feedbackDate,
			ArrayList<String> keywords, String signature) {
		super();
		this.bookID = bookID;
		this.userName = userName;
		this.feedbackTitle = feedbackTitle;
		this.feedbackText = feedbackText;
		this.feedbackDate = feedbackDate;
		this.keywords = keywords;
		this.signature = signature;
	}

	public Purchases(String specific_feild,int num){
		if(num==1){
			this.Author=specific_feild;
			this.select_case=1;
		}
		if(num==2){
			this.Title=specific_feild;
		this.select_case=2;
		}
		//if(num==3)
			//this.Keywords=specific_feild;
	}
	
	
	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFeedbackTitle() {
		return feedbackTitle;
	}

	public void setFeedbackTitle(String feedbackTitle) {
		this.feedbackTitle = feedbackTitle;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(LocalDate feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public ArrayList<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public int getSelect_case() {
		return select_case;
	}	

}