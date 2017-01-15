package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public abstract class AbstractFolderElement extends JPanel {

	private String name;
	
	public AbstractFolderElement(String name, BufferedImage folderIcon){
		this.name= name;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Folder icon
		JLabel iconLabel= new JLabel(new ImageIcon(folderIcon));
		add(iconLabel);
		
		// Category name
		JLabel nameLabel= new JLabel(name, SwingConstants.RIGHT);
		add(nameLabel);
		
		// Make it clickable
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public String getName(){
		return name;
	}
}
