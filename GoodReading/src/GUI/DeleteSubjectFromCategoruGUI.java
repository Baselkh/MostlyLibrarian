package GUI;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

import client.controller.CategoriesController;
import client.controller.ControllerType;
import client.controller.Controllers;
import client.controller.SubjectsController;
import protocol.request.RemoveSubjectsFromCategoryRequest;
import protocol.response.AddBooksToSubjectResponse;
import protocol.response.RemoveSubjectsFromCategoryResponse;

/**
 * @author Basel
 *
 */
public class DeleteSubjectFromCategoruGUI extends AbstractQueueableWindow{

	private JTable table;
	private int numOfRows, numOfCols;
	private JButton confirmButton;
	private JButton cancelButton;
	private String categoryName;

	public DeleteSubjectFromCategoruGUI(ArrayList<String> subjectsIDs, ArrayList<String> subjectsNames, String categoryName){
		super("Removing Subjects From Category");

		this.categoryName = categoryName;

		Container pane= getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		confirmButton= new JButton("Confirm");
		cancelButton= new JButton("Cancel");
		JPanel buttonsContainer= new JPanel(new FlowLayout());
		buttonsContainer.add(confirmButton);
		buttonsContainer.add(cancelButton);
		pane.add(buttonsContainer);

		// Creating the table
		numOfRows = subjectsIDs.size();
		numOfCols = 3;
		Object[][] data = new Object[numOfRows][numOfCols];

		int i = 0;
		for(String s : subjectsIDs){
			int j = 0;
			data[i][j] = new Boolean(false);
			j++;
			data[i][j] = s;
			j++;
			data[i][j] = subjectsNames.get(i);
			i++;
		}

		table = new JTable(new MyTableModel(data));
		table.setPreferredScrollableViewportSize(new Dimension(500, 300));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(
				ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		//Add the scroll pane to this panel.
		pane.add(scrollPane);

		ButtonHandler handler = new ButtonHandler();
		confirmButton.addActionListener(handler);
		cancelButton.addActionListener(handler);

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

		// Displaying
		pack();
		setVisible(true);
	}

	private class MyTableModel extends AbstractTableModel {
		String[] columnNames = {"",
				"Subject ID",
		"Subject Name"};
		private Object[][] data;

		public MyTableModel(Object[][] data){
			this.data= data;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		/*
		 * JTable uses this method to determine the default renderer/
		 * editor for each cell.  If we didn't implement this method,
		 * then the last column would contain text ("true"/"false"),
		 * rather than a check box.
		 */
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/*
		 * Don't need to implement this method unless your table's
		 * editable.
		 */
		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			if (col == 0) {
				return true;
			} else {
				return false;
			}
		}

		/*
		 * Don't need to implement this method unless your table's
		 * data can change.
		 */
		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}

	}

	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancelButton)
				removeFromQueue();
			else{
				ArrayList<String> subjectsIDs = new ArrayList<String>();
				for(int i = 0; i < numOfRows; i++)
					if((Boolean)table.getValueAt(i, 0))
						subjectsIDs.add((String)table.getValueAt(i, 1));

				if(subjectsIDs.size() == 0)	// No book is selected to be removed
					JOptionPane.showMessageDialog(null, "Please select books that you wish to remove");
				else{	// One ore more books is selected
					CategoriesController controller= (CategoriesController) 
							Controllers.getInstance().getController(ControllerType.CATEGORY_CONTROLLER);
					RemoveSubjectsFromCategoryResponse resp= controller.removeSubjectsFromCategory(subjectsIDs, categoryName);
					if(!resp.getOperationStatus()){
						JOptionPane.showMessageDialog(null, "ERROR");
					}
					for(int i = 0; i < 2; i++)
						removeFromQueue();
					new SubjectsInCategoryGUI(categoryName);
				}
			}
		}
	}
}
