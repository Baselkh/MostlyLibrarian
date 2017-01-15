package GUI;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Basel
 *
 */
public class EditSubjectsGUI extends JFrame implements ActionListener {
	
	private JButton createSubjectButton;
	private JButton deleteSubjectButton;
	private JButton renameSubjectButton;
	
	public EditSubjectsGUI() {
		JFrame frame = new JFrame("Edit Subjects");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createSubjectButton= new JButton("Create Subject");
        deleteSubjectButton= new JButton("Delete Subject");
        renameSubjectButton= new JButton("Rename Subject");
        
        JPanel panel= new JPanel();
        panel.add(createSubjectButton);
        panel.add(deleteSubjectButton);
        panel.add(renameSubjectButton);
                
        frame.add(panel);
        
//      Display the window
        frame.pack();
        frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(createSubjectButton)){
			
		}
	}
	
//	public static void main(String args[]){
//		new EditSubjectsGUI();
//	}
}
