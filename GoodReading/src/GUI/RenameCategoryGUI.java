package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 * @author Basel
 *
 */
public class RenameCategoryGUI extends JFrame implements ActionListener {
	
	JTextField textField;
	JButton confirmButton;
	JButton cancelButton;
	
	public RenameCategoryGUI() {
		JFrame frame= new JFrame("Create Subject");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane= frame.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        textField= new JTextField("Subject's Name");
        confirmButton= new JButton("Confirm");
        cancelButton= new JButton("Cancel");
        
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        pane.add(textField);
        pane.add(confirmButton);
        pane.add(cancelButton);
        
//        Display the window
        frame.pack();
        frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(confirmButton)){
			
		}
		else if(e.getSource().equals(cancelButton)){
			
		}
	}
}
