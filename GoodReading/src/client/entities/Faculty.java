package client.entities;

public class Faculty {
	private String facultyName;
	private String facultyID;
	
	public Faculty(String facultyName,String facultyID){
		this.facultyID=facultyID;
		this.facultyName=facultyName;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}
	

}
