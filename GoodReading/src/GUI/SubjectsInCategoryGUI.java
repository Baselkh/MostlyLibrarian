package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import client.controller.CategoriesController;
import client.controller.ControllerType;
import client.controller.Controllers;
import client.controller.SubjectsController;
import client.entities.Book;
import protocol.response.BooksInSubjectResponse;
import protocol.response.SubjectsInCategoryResponse;

/**
 * @author Basel
 *
 */
public class SubjectsInCategoryGUI extends AbstractQueueableWindow {

	private JButton createSubjectButton;
	private JButton deleteSubjectButton;
	private JButton renameSubjectButton;
	private BufferedImage folderIcon;
	private MouseAdapter mouseClickListener;
	private String categoryName;
	private ArrayList<String> subjectsIDs;
	private ArrayList<String> subjectsNames;
	
	public SubjectsInCategoryGUI(String categoryName){
		super(categoryName);
		
		this.categoryName = categoryName;
		
		Container pane= getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		// Initializing buttons
		createSubjectButton= new JButton("Create Subject");
		deleteSubjectButton= new JButton("Delete Subject");
		renameSubjectButton= new JButton("Rename Subject");
		
		// Adding buttons
		JPanel buttonsPanel= new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));	// Panel for containing buttons
		buttonsPanel.add(createSubjectButton);
		buttonsPanel.add(deleteSubjectButton);
		buttonsPanel.add(renameSubjectButton);
		pane.add(buttonsPanel);
		
		CategoriesController controller= (CategoriesController) 
				Controllers.getInstance().getController(ControllerType.CATEGORY_CONTROLLER);
		SubjectsInCategoryResponse response= controller.getSubjectsInCategory(categoryName);
		subjectsIDs= response.getSubjectsIDs();
		subjectsNames= response.getSubjectsNames();
		
		// Categories icons layout
		JPanel iconsPanel= new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		try{	// Initializing the pointer to the icon
			folderIcon= ImageIO.read(new File("images\\folder_icon.png"));
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(null, "Something went wrong!!");
			dispose();
		}
		createFolderClickListener();
		for(int i= 0; i < subjectsIDs.size(); i++)
			iconsPanel.add(makeFolderIcon(subjectsIDs.get(i), subjectsNames.get(i)));
		pane.add(iconsPanel);
		
		// Adding buttons click listener
		ClickListener clickListener= new ClickListener();
		createSubjectButton.addActionListener(clickListener);
		deleteSubjectButton.addActionListener(clickListener);
		renameSubjectButton.addActionListener(clickListener);
		
		// Back button
		pane.add(Box.createRigidArea(new Dimension(1, 40)));
		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowsViewManager.removeFromQueue();
			}
		});
		pane.add(backButton);
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(Box.createRigidArea(new Dimension(1, 80)));
		
		// Displaying
		pack();
		setVisible(true);
	}
	
	private void createFolderClickListener(){
		mouseClickListener= new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				SubjectFolderElement subject= (SubjectFolderElement)e.getSource();
//				JOptionPane.showMessageDialog(null, subject.getName()+" is pressed");
				String subjectID= ((SubjectFolderElement)e.getSource()).getID();
				SubjectsController controller= (SubjectsController) 
						Controllers.getInstance().getController(ControllerType.SUBJECT_CONTROLLER);
				BooksInSubjectResponse resp= controller.getBooksInSubject(subjectID);
				ArrayList<Book> books= resp.getBooks();
				
				new BooksInSubjectGUI(subject.getID(), subject.getName());
				setVisible(false);
			}
		};
	}
	
	private SubjectFolderElement makeFolderIcon(String subjectID, String subjectName){
		SubjectFolderElement folder= new SubjectFolderElement(subjectID, subjectName, folderIcon);
		folder.addMouseListener(mouseClickListener);
		return folder;
	}
	
	private class ClickListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == createSubjectButton)
				new CreateSubjectGUI(categoryName);
			
			else if(e.getSource() == deleteSubjectButton)
				new DeleteSubjectFromCategoruGUI(subjectsIDs, subjectsNames, categoryName);
			
			else if(e.getSource() == renameSubjectButton)
				new SelectSubjectToRenameGUI(subjectsIDs, subjectsNames);
		}
	}
}
