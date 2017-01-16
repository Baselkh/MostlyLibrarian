package GUI;

import java.awt.Color;
import java.awt.Container;
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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.oracle.jrockit.jfr.ContentType;

import GUI.AbstractFolderElement;
import client.controller.CategoriesController;
import client.controller.ControllerType;
import client.controller.Controllers;
import protocol.response.GetAllCategoriesResponse;
import protocol.response.SubjectsInCategoryResponse;

/**
 * @author Basel
 *
 */
public class CategoriesGUI extends JFrame {

	private JButton createCategoryButton;
	private JButton deleteCategoryButton;
	private JButton renameCategoryButton;
	private BufferedImage folderIcon;
	private ArrayList<String> categoriesNames;
	private ArrayList<String> categoriesIDs;
	private MouseAdapter mouseClickListener;
	
	public CategoriesGUI(){
		super("Categories");
		Container pane= getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		// Initializing buttons
		createCategoryButton= new JButton("Create Category");
		deleteCategoryButton= new JButton("Delete Category");
		renameCategoryButton= new JButton("Rename Category");
		
		// Adding buttons
		JPanel buttonsPanel= new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));	// Panel for containing buttons
		buttonsPanel.add(createCategoryButton);
		buttonsPanel.add(deleteCategoryButton);
		buttonsPanel.add(renameCategoryButton);
		pane.add(buttonsPanel);
		
		
		// Categories icons layout
		JPanel iconsPanel= new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		try{	// Initializing the pointer to the icon
			folderIcon= ImageIO.read(new File("images\\folder_icon.png"));
		}
		catch(IOException e){}	///////Messing Code/////////
		readCategoriesNames();	// Getting categories names
		createFolderClickListener();
		for(String s: categoriesNames){
			iconsPanel.add(makeFolderIcon(s));
		}
		pane.add(iconsPanel);
		
		// Displaying
		pack();
		setVisible(true);
	}
	
	private CategoryFolderElement makeFolderIcon(String categoryName){
		CategoryFolderElement folder= new CategoryFolderElement(categoryName, folderIcon);
		folder.addMouseListener(mouseClickListener);
		return folder;
	}
	
	private void readCategoriesNames(){
		CategoriesController controller= (CategoriesController) 
				Controllers.getInstance().getController(ControllerType.CATEGORY_CONTROLLER);
		GetAllCategoriesResponse resp= controller.GetAllCategories();
		categoriesNames= resp.getCategoriesNames();
	}
	
	private void createFolderClickListener(){
		mouseClickListener= new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String categoryName= ((AbstractFolderElement)e.getSource()).getName();
//				JOptionPane.showMessageDialog(null, categoryName+" is pressed");

				new SubjectsInCategoryGUI(categoryName);
			}
		};
	}
	
	public static void main(String args[]){
		new CategoriesGUI();
	}
}
