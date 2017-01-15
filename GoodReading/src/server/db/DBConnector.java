package server.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import client.entities.Book;
import client.entities.Purchases;
import client.entities.User;
import protocol.response.BooksInSubjectResponse;
import protocol.response.SubjectsInCategoryResponse;

public class DBConnector {
	public Connection connDB;
	
	public void connect(String dbName, String user, String pass)
			throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connDB = DriverManager.getConnection("jdbc:mysql://localhost/"
					+ dbName, user, pass);
			System.out.println("SQL connection succeed");
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param user
	 *            : to check if the user ID exist in the database
	 * @return true if ID exist, else false
	 * @throws SQLException
	 */
	public boolean isUser(User user) throws SQLException {
		try {
			Statement Stmt = connDB.createStatement();
			ResultSet rs = Stmt.executeQuery("SELECT * FROM good_reading.users WHERE username="
					+ "'" + user.getUserName() + "'");
			///if you WANT to check string add "'" + user.getUseName() + "'"
			//if we use int no need to add ///
			if (!(rs.next()))  return false;
			
			rs.close();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/**
	 * 
	 * @param user
	 *            : has the ID and the password that the user insert in the GUI
	 * @return true if the password is Suitable to the ID, else return false
	 * @throws SQLException
	 */
	public boolean checkPassword(User user) throws SQLException {
		try {
			Statement Stmt = connDB.createStatement();
			ResultSet rs = Stmt.executeQuery("SELECT * FROM good_reading.users WHERE username="
					+ "'" + user.getUserName() + "'" + " AND Password=" + user.getPassword());
			if (!(rs.next()))  return false;
			
			rs.close();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param user
	 *            : has the ID and the password that the user insert in the GUI
	 * @return true if the user is already logged In, els return false
	 * @throws SQLException
	 */
	public boolean isLoggedIn(User user) throws SQLException {
		try {
			Statement Stmt = connDB.createStatement();
			ResultSet rs = Stmt.executeQuery("SELECT * FROM users WHERE username="
					+ "'"
					+ user.getUserName() + "'"+ " AND Status=1");
			if (!(rs.next())) return false;
			
			rs.close();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/**
	 * markAsLoggedIn-- change the status to 1 that marks the user is logged in
	 * 
	 * @param user
	 *            : has the ID and the password that the user insert in the GUI
	 * @throws SQLException
	 */
	public void markAsLoggedIn(User user) throws SQLException {
		try {
			Statement Stmt = connDB.createStatement();
			Stmt.executeUpdate("UPDATE users SET Status=1 WHERE username="+ "'"
					+ user.getUserName()+ "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * markAsLoggedOut-- change the status to 0 that marks the user is logged
	 * out
	 * 
	 * @param user
	 *            : has the ID and the password that the user insert in the GUI
	 * @throws SQLException
	 */
	public void markAsLoggedOut(User user) throws SQLException {
		try {
			Statement Stmt = connDB.createStatement();	
			Stmt.executeUpdate("UPDATE users SET Status=0 WHERE username="+ "'"
					+ user.getUserName()+ "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}// end markAsLoggedOut
	
	/**
	 * 
	 * @param user
	 *            : has the ID and the password that the user insert in the GUI
	 * @return all the needed information about the user from the DataBase.
	 * @throws SQLException
	 */
	public User fillUser(User user) throws SQLException {
		try {
			Statement stmt = connDB.createStatement();
			User currUser = new User(user.getUserName(), user.getPassword());
			ResultSet rs = stmt.executeQuery("SELECT firstname,lastname,type FROM users WHERE username = " + "'" + user.getUserName() + "'");
			rs.first();
			currUser.fillDetails(rs.getString(1), rs.getString(2), rs.getInt(3));
			rs.close();
			return currUser;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Book> booksearch(Book book)
	{
		
		try {
			Statement stmt = connDB.createStatement();
			Book book1 = new Book(book.getBookID(),book.getTitle(),book.getLanguage(),book.getAuthors());
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE BookID = "+book1.getBookID()+" Title= "+book1.getTitle()+" Language= "+book1.getLanguage());
			rs.first();
			ArrayList<Book> books=new ArrayList<Book>();
			 book1.createArrayList();
			while(rs.next())
			{
				Book book2=new Book(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
				books.add(book2);
			}
			
			return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	
	}
	
	public boolean getFeildFromFeedback(Purchases pur,int field){
		try {
			Statement Stmt = connDB.createStatement();
			if(field==1){
				ResultSet rs = Stmt.executeQuery("SELECT bookID,userName,feedbackTitle,feedbackText FROM good_reading.bookfeedbacks WHERE Author="
						+ "'" + pur.getAuthor() + "'");
				if (!(rs.next()))  return false;
				
				rs.close();
				return true;
			}//if the user search author"
				
			if(field==2){
			ResultSet rs = Stmt.executeQuery("SELECT bookID,userName,feedbackTitle,feedbackText FROM good_reading.bookfeedbacks WHERE booktitle="
					+ "'" + pur.getTitle() + "'");
			if (!(rs.next()))  return false;
			
			rs.close();
			return true;
		
			}//if the user search "title"
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}


	public SubjectsInCategoryResponse getSubjectsInCategory(String categoryName){
		try {
			Statement st = connDB.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT SubjectID,SubjectName FROM subjects WHERE Category='"+categoryName+"';");
			ArrayList<String> arr1= new ArrayList<String>();	// saves IDs
			ArrayList<String> arr2= new ArrayList<String>();	// saves Names
			while(rs.next()){
				arr1.add(rs.getString(1));
				arr2.add(rs.getString(2));
			}
			rs.close();
			return new SubjectsInCategoryResponse(arr1, arr2);
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> getAllCategories() {
		try {
			Statement st = connDB.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT CategoryName FROM categories;");
			ArrayList<String> arr= new ArrayList<String>();
			while(rs.next())
				arr.add(rs.getString(1));
			rs.close();
			return arr;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public BooksInSubjectResponse getBooksInSubject(String subjectID){
		try {
			Statement st = connDB.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT BookID "
							+ "FROM books_in_subject "
							+ "WHERE SubjectID='"+subjectID+"';"); 
			
			ArrayList<String> booksIDs= new ArrayList<String>();
			while(rs.next()){
				booksIDs.add(rs.getString(1));
			}
			rs.close();
			
			ArrayList<Book> books= new ArrayList<Book>();
			for(String bookID: booksIDs){
				books.add(getBook(bookID));
			}
			
			return new BooksInSubjectResponse(books);
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private Book getBook(String bookID){
		try {
			Statement stmt = connDB.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * "
					+ "FROM books "
					+ "WHERE BookID='"+bookID+"';");
			Book book= null;
// BookID, Title, Language, Summary, TableOfContents, DownloadsNumber, Keywords, Author
			if(rs.next())
				book= new Book(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8));
			rs.close();
			return book;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
