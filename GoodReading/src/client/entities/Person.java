package client.entities;

/**
 * @author Basel
 *
 */
public abstract class Person {

	private String ID;
	private String firstName;
	private String lastName;
	
	public Person(String iD, String firstName, String lastName) {
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param ID
	 * @param firstName
	 * @param lastName
	 */
		
}