package client.entities;

import java.io.Serializable;

/**
 * @author Basel
 *
 */
public class User extends Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private int userType;

	/**
	 * @param userName
	 * @param password
	 * @param ID
	 * @param firstName
	 * @param lastName
	 */

	
	public void fillDetails(String Fname,String Lname,int type){
		super.setFirstName(Fname);
		super.setLastName(Lname);
		setUserType(type);
	}//end fillDetails()

	public User(String iD, String firstName, String lastName, String userName, String password) {
		super(iD, firstName, lastName);
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName,String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
}
