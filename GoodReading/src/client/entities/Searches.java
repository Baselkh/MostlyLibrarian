package client.entities;

public class Searches extends Book{
	private long numOfSearchres;
	//Date sDate;

	public Searches(String bookID, String Title, String Language,
			long downloadsNum,String Author) {
		super(bookID, Title, Language, Author);
		
	}

	public long getNumOfSearchres() {
		return numOfSearchres;
	}

	public void setNumOfSearchres(long numOfSearchres) {
		this.numOfSearchres = numOfSearchres;
	}
	
	

}
