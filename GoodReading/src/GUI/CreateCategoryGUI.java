package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 * @author Basel
 *
 */
public class CreateCategoryGUI extends JFrame implements ActionListener {
	
	JTextField categoryNameTextField;
	JButton confirmButton;
	JButton cancelButton;
	
	public CreateCategoryGUI() {
		JFrame frame= new JFrame("Create Subject");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane= frame.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        categoryNameTextField= new JTextField("Subject's Name");
        confirmButton= new JButton("Confirm");
        cancelButton= new JButton("Cancel");
        
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        categoryNameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        Container borderLayout= new Container();
        borderLayout.setLayout(new BorderLayout());
        borderLayout.add(categoryNameTextField, BorderLayout.PAGE_START);
        
        pane.add(borderLayout);
        pane.add(confirmButton);
        pane.add(cancelButton);
        
//        Display the window
        frame.pack();
        frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(confirmButton)){
			String categoryName= categoryNameTextField.getText();
			
		}
		else if(e.getSource().equals(cancelButton)){
			
		}
	}
	
//	public static void main(String args[]){
//		new CreateCategoryGUI();
//	}
}
