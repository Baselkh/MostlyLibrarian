package server.ui;

import java.util.ArrayList;
import java.util.Random;

public abstract class IDsGenerator {

	private ArrayList<String> IDs;
	
	public IDsGenerator(){
		IDs= new ArrayList<String>();
		IDs.add("");
	}
	
	public String generateID(){
		Random rand = new Random();
		int n;
		String id= "";
		while(IDs.contains(id)){
			n= rand.nextInt(200) + 1;
			id= ""+n;
		}
		IDs.add(id);
		return id;
	}
	
	public void removeID(String id){
		IDs.remove(id);
	}
}
