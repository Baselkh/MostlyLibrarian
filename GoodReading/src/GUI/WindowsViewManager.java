package GUI;

import java.util.ArrayList;

import javax.swing.JFrame;

public class WindowsViewManager {

	private static ArrayList<AbstractQueueableWindow> framesQueue;
	private static WindowsViewManager currentInstance;
	
	public WindowsViewManager(){
		currentInstance = this;
		framesQueue = new ArrayList<AbstractQueueableWindow>();
	}
	
	public void addToQueue(AbstractQueueableWindow window){
		int size = framesQueue.size(); 
		if(size != 0){	// Another window is open
			framesQueue.get(size-1).hideWindow();	// Hiding the open window
		}
		framesQueue.add(window);
		window.displayWindow();
	}
	
	public static void removeFromQueue(){
		int size = framesQueue.size();
		if(size == 0)
			return;
		framesQueue.get(size-1).deleteWindow();
		framesQueue.remove(size-1);
		if(size >= 2)
			framesQueue.get(size-2).displayWindow();
		else{
			// Need to be handled ###############################################################
			// Need to be handled ###############################################################
			// Need to be handled ###############################################################
		}
	}

	public static WindowsViewManager getInstance(){
		if(currentInstance == null)
			return new WindowsViewManager();
		return currentInstance;
	}
}
