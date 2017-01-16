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
public class DeleteCategoryGUI extends JFrame implements ActionListener {
	
	public DeleteCategoryGUI() {
		super("Create Subject");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane= getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
//        Display the window
        pack();
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
