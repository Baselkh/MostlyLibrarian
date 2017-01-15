package client.entities;

public class Worker extends Person{

	private int workerNum;
	private String Email;
	private String Position;
	private String OrganizationalAffiliation;
	
	public Worker(String ID, String firstName, String lastName) {
		super(ID, firstName, lastName);
		
	}

	public int getWorkerNum() {
		return workerNum;
	}

	public void setWorkerNum(int workerNum) {
		this.workerNum = workerNum;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}
	

}
