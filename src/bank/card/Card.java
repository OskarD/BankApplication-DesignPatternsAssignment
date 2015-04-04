package bank.card;

import java.util.*;
import java.text.*;


public abstract class Card {
	private String owner;
	private String cardNum;
	private Date exp;
	
	public Card(String owner) { 
		setOwner(owner);
	}
	
	public void transaction() {  }
    
    public String getOwner() { return this.owner; }
    public void setOwner(String owner) { this.cardNum = owner; }
    
    public String getCardNumm() { return this.cardNum; }
    public void setCardNum(String cardNum) { this.cardNum = cardNum; }
    
    public String getExpDate() {
    	SimpleDateFormat ft = new SimpleDateFormat("MM-yy"); 
    	return ft.format(this.exp);
    }
    public void setExpDate() {
    	// This will automatically be set in Debit (5 years from date of creation)
    	// and Credit (2 years from date of creation).
    }
	
	
	/* ToDo: Add Appropriate Method */

	public static String bankInfo(){
    	String bankName = "Our Bank";
        String assress = "132 Fake Street";
        String city = "Come By Chance";
        String prov = "Newfoundland";
        String post = "A1B2C3";
        String contactNum = "1-800-123-4567";
        
    	return bankName + "\n" + assress + "\n" + city + ",  " + prov 
        		+ "\n" + post + "\nFor Customer Support Call: " + contactNum;
    }
    
    @Override
    public String toString(){
    	return getOwner() + "\n" + getCardNumm() + "\nValid Thru: " + getExpDate() + "\n\n" +  bankInfo();
    }
}