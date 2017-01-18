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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.controller.CategoriesController;
import client.controller.ControllerType;
import client.controller.Controllers;
import protocol.response.RenameCategoryResponse;

/**
 * @author Basel
 *
 */
public class RenameCategoryGUI extends AbstractQueueableWindow implements ActionListener  {
	
	private JTextField textField;
	private String oldName;
	private JButton confirmButton;
	private JButton cancelButton;
	
	public RenameCategoryGUI(String oldCategoryName) {
		super("Rename Subject");
		
		this.oldName = oldCategoryName;
		
        Container pane= getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.setMinimumSize(new Dimension(500, 80));
        
        JLabel oldNameLabel= new JLabel("Current Name: "+oldCategoryName);
        oldNameLabel.setPreferredSize(new Dimension(400, 30));
        JPanel oldNameWrapper= new JPanel(new FlowLayout());
        oldNameWrapper.add(oldNameLabel);
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
			RenameCategoryResponse resp= controller.
					renameCategory(oldName, textField.getText());
			
			if(!resp.getOperationStatus())
				JOptionPane.showMessageDialog(null, "ERROR");
			
			for(int i = 0; i < 3; i++)
				removeFromQueue();
			new CategoriesGUI();
		}
		else if(e.getSource().equals(cancelButton)){
			removeFromQueue();
		}
	}
}
