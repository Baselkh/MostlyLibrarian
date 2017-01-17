package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public abstract class AbstractQueueableWindow extends JFrame implements ViewQueueable {

	public void hideWindow(){
		setVisible(false);
	}

	public void displayWindow(){
		setVisible(true);
	}
	
	public void deleteWindow(){
		dispose();
	}

	protected void addToQueue(){
		WindowsViewManager.getInstance().addToQueue((AbstractQueueableWindow)this);
	}
	
	protected void removeFromQueue(){
		WindowsViewManager.getInstance().removeFromQueue();
	}
	
	public AbstractQueueableWindow(String windowName){
		super(windowName);
		setPreferredSize(getMaximumSize());
		addToQueue();
	}
}
