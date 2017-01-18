package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.controller.CategoriesController;
import client.controller.ControllerType;
import client.controller.Controllers;
import protocol.request.RenameSubjectRequest;
import protocol.response.AddSubjectToCategoryResponse;
import protocol.response.RenameSubjectResponse;

public class RenameSubjectGUI extends AbstractQueueableWindow implements ActionListener  {

	private JTextField textField;
	private JLabel oldName;
	private JButton confirmButton;
	private JButton cancelButton;
	private String subjectID;
	
	public RenameSubjectGUI(String subjectID, String oldSubjectName) {
		super("Rename Subject");
		
        this.subjectID = subjectID;
        
        Container pane= getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.setMinimumSize(new Dimension(500, 80));
        
        oldName= new JLabel(oldSubjectName);
        oldName.setPreferredSize(new Dimension(400, 30));
        JPanel oldNameWrapper= new JPanel(new FlowLayout());
        oldNameWrapper.add(oldName);
        oldNameWrapper.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pane.add(oldNameWrapper);
        
        textField= new JTextField();
        textField.setPreferredSize(new Dimension(400, 30));
        JPanel textFieldWrapper= new JPanel(new FlowLayout());
        textFieldWrapper.add(textField);
        textFieldWrapper.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pane.add(textFieldWrapper);
        
        pane.add(Box.createRigidArea(new Dimension(1, 10)));
        
        confirmButton= new JButton("Confirm");
        pane.add(confirmButton);
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        pane.add(Box.createRigidArea(new Dimension(1, 10)));
        
        cancelButton= new JButton("Cancel");
        pane.add(cancelButton);
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        pane.add(Box.createRigidArea(new Dimension(1, 10)));
        
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
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
        
//        Display the window
        pack();
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(confirmButton)){
			CategoriesController controller= (CategoriesController) 
					Controllers.getInstance().getController(ControllerType.CATEGORY_CONTROLLER);
			RenameSubjectResponse resp= controller.
					renameSubject(subjectID, textField.getText());
			
			if(!resp.getOperationStatus())
				JOptionPane.showMessageDialog(null, "ERROR");
			
			for(int i = 0; i < 3; i++)
				removeFromQueue();
			new SubjectsInCategoryGUI(resp.getCategoryName());
		}
		else if(e.getSource().equals(cancelButton)){
			removeFromQueue();
		}
	}
}
