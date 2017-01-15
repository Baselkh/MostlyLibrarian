package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import client.entities.Book;

public class BooksInSubjectElementGUI extends JPanel {

	private JRadioButton rb;
	private JLabel bookIDLabel;
	private JLabel titleLabel;
	private JLabel languageLabel;
	private JLabel summaryLabel;
	private JLabel tableOfContentsLabel;
	private JLabel downloadsNumLabel;
	private JLabel keywordsLabel;
	private JLabel authorsLabel;
	private ArrayList<JLabel> componentsArray;
	private int horizontalPadding= 7;
	
	public BooksInSubjectElementGUI(Book book, boolean selectionEnabled){
		setLayout(new GridLayout(1, 9));
		
		componentsArray= new ArrayList<JLabel>();
		
		if(selectionEnabled){
			rb= new JRadioButton();
			add(rb);
		}
		else
			add(new JLabel());
		
		bookIDLabel= new JLabel(book.getBookID());
		componentsArray.add(bookIDLabel);
		add(bookIDLabel);
		
		titleLabel= new JLabel(book.getTitle());
		componentsArray.add(titleLabel);
		add(titleLabel);
		
		languageLabel= new JLabel(book.getLanguage());
		componentsArray.add(languageLabel);
		add(languageLabel);
		
		summaryLabel= new JLabel(book.getSummary());
		componentsArray.add(summaryLabel);
		add(summaryLabel);
		
		tableOfContentsLabel= new JLabel(book.getTableOfContents());
		componentsArray.add(tableOfContentsLabel);
		add(tableOfContentsLabel);
		
		downloadsNumLabel= new JLabel(book.getDownloadsNumber());
		componentsArray.add(downloadsNumLabel);
		add(downloadsNumLabel);
		
		keywordsLabel= new JLabel(book.getKeywords());
		componentsArray.add(keywordsLabel);
		add(keywordsLabel);
		
		authorsLabel= new JLabel(book.getAuthors());
		componentsArray.add(authorsLabel);
		add(authorsLabel);
		
		if(!selectionEnabled){
			ArrayList<JLabel> arr= new ArrayList<JLabel>();
			arr.add(bookIDLabel);
			arr.add(titleLabel);
			arr.add(languageLabel);
			arr.add(summaryLabel);
			arr.add(tableOfContentsLabel);
			arr.add(downloadsNumLabel);
			arr.add(keywordsLabel);
			arr.add(authorsLabel);
			
			for(JLabel label: arr){
				label.setOpaque(true);
				label.setBackground(Color.CYAN);
				label.setBorder(BorderFactory.createEmptyBorder(15, horizontalPadding, 15, horizontalPadding));
			}
		}
		else
			addBorders();
	}
	
	private void addBorders(){
		for(JLabel label: componentsArray){
			label.setBorder(BorderFactory.createEmptyBorder(2, horizontalPadding, 2, horizontalPadding));
		}
	}
}
