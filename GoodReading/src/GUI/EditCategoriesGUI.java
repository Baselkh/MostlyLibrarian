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
public class EditCategoriesGUI extends JFrame implements ActionListener {
	
	private JButton createCategoryButton;
	private JButton deleteCategoryButton;
	private JButton renameCategoryButton;
	
	public EditCategoriesGUI() {
		JFrame frame = new JFrame("Edit Categories");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initializing
        createCategoryButton= new JButton("Create Category");
        deleteCategoryButton= new JButton("Delete Category");
        renameCategoryButton= new JButton("Rename Category");
        
        // Assigning listener
        createCategoryButton.addActionListener(this);
        deleteCategoryButton.addActionListener(this);
        renameCategoryButton.addActionListener(this);
        
        JPanel panel= new JPanel();
        panel.add(createCategoryButton);
        panel.add(deleteCategoryButton);
        panel.add(renameCategoryButton);
                
        frame.add(panel);
        
//      Display the window
        frame.pack();
        frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(createCategoryButton)){
			new CreateCategoryGUI();
		}
	}
	
//	public static void main(String args[]){
//		new EditCategoriesGUI();
//	}
}
