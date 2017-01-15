package client.controller;

/**
 * 
 * @author Sahar This enum specifies the type of user
 */
public enum UserType {
	User(1),
	Member(2), 
	Librarian(3), 
	CertifiedEditor(4), 
	LibraryManager(5);

	private final int type;

	/**
	 * This is the constructor for this class
	 */
	private UserType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

}
