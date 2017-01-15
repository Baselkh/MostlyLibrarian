package client.entities;

public class Paymentmethod {
	long cardNumber;
	//Date expirationDate;
	int securityCode;
	
	public Paymentmethod(long cardNumber,int securityCode){
		this.cardNumber=cardNumber;
		this.securityCode=securityCode;
		
	}
	
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	

}
