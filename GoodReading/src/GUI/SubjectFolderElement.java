package GUI;

import java.awt.image.BufferedImage;

public class SubjectFolderElement extends AbstractFolderElement {

	private String subjectID;
	private String subjectName;
	
	public SubjectFolderElement(String subjectID, String subjectName, BufferedImage folderIcon){
		super(subjectName, folderIcon);
		this.subjectID= subjectID;
	}
	
	public String getID(){
		return subjectID;
	}
}
