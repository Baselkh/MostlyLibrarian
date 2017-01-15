package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import client.entities.Book;

public class BooksInSubjectGUI extends JFrame {

	public BooksInSubjectGUI(String subjectName, ArrayList<Book> books){
		super(subjectName);
		Container pane= getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		Book columnesNames= new Book("Book ID", "Title", "Language", "Summary", "Table of Contents", "Downloads Number", "Keywords", "Authors");
		pane.add(new BooksInSubjectElementGUI(columnesNames, false));
		for(Book b: books){
			pane.add(new BooksInSubjectElementGUI(b, true));
		}
		
		// Displaying
		pack();
		setVisible(true);
	}
}
