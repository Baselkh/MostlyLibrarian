package client.entities;

public class Subject {
	private String subjectName;
	private String subjectID;
	
	public Subject(String subjectName,String subjectID){
		this.subjectName=subjectName;
		this.subjectID=subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

}
