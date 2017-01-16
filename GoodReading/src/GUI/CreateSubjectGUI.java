package GUI;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.controller.CategoriesController;
import client.controller.ControllerType;
import client.controller.Controllers;
import client.controller.SubjectsController;
import protocol.response.AddSubjectToCategoryResponse;
import protocol.response.BooksInSubjectResponse;
import protocol.response.SubjectsInCategoryResponse;

/**
 * @author Basel
 *
 */
public class CreateSubjectGUI extends JFrame implements ActionListener {
	
	private String categoryName;
	JTextField textField;
	JButton confirmButton;
	JButton cancelButton;
	private static CreateSubjectGUI currentInstance;
	
	public CreateSubjectGUI(String categoryName) {
		super("Create Subject");
		if(currentInstance != null)
			currentInstance.dispose();
		currentInstance= this;
		this.categoryName= categoryName;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container pane= getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.setMinimumSize(new Dimension(500, 80));
        
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
        
//        Display the window
        pack();
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(confirmButton)){
			CategoriesController controller= (CategoriesController) 
					Controllers.getInstance().getController(ControllerType.CATEGORY_CONTROLLER);
			AddSubjectToCategoryResponse resp= controller.
					addSubjectToCategory(categoryName, textField.getText());
			if(resp.operationIsSuccessful()){
				JOptionPane.showMessageDialog(null, "Done!");
				new SubjectsInCategoryGUI(categoryName);
				dispose();
			}
			else
				JOptionPane.showMessageDialog(null, "ERROR");
		}
		else if(e.getSource().equals(cancelButton)){
			dispose();
		}
	}
	
//	public static void main(String[] args){
//		new CreateSubjectGUI("Test");
//	}
}
