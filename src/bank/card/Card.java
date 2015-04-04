package bank.card;

public abstract class Card {
	private String cardNum;
	private static CardBankInfo uniqueInstance = new CardBankInfo();
	
	public Card() {  }
	
	public void transaction() {  }
	
	public static synchronized CardBankInfo getCardBankInfoInst()
    {
        if (uniqueInstance == null)
            uniqueInstance = new CardBankInfo();
        return uniqueInstance;
    }
    
    public String getCardNumm() { return this.cardNum; }
    public void setCardNum(String cardNum) { this.cardNum = cardNum; }
	
	
	/* ToDo: Add Appropriate Method */
}

class CardBankInfo{
	private String bankName = "Our Bank";
    private String assress = "132 Fake Street";
    private String city = "Come By Chance";
    private String prov = "Newfoundland";
    private String post = "A1B2C3";
    private String contactNum = "1-800-123-4567";
    
    public void setInfo(String bankName, String assress, String city, String prov, 
    		String post, String contactNum)
    {
        setBankName(bankName);
        setAssress(assress);
        setCity(city);
        setProv(prov);
        setPost(post);
        setContactNum(contactNum);
    }
    
    public String getBankName() { return this.bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }
    
    public String getAssress() { return this.assress; }
    public void setAssress(String assress) { this.assress = assress; }
    
    public String getCity() { return this.city; }
    public void setCity(String city) { this.city = city; }
    
    public String getProv() { return this.prov; }
    public void setProv(String prov) { this.prov = prov; }
    
    public String getPost() { return this.post; }
    public void setPost(String post) { this.post = post; }
    
    public String getContactNum() { return this.contactNum; }
    public void setContactNum(String contactNum) { this.post = contactNum; }
    
    @Override
    public String toString()
    {
        return getBankName() + "\n" + getAssress() + "\n" + getCity() + ",  " + getProv() 
        		+ "\n" + getPost() + "\nFor Customer Support Call: " + getContactNum();
    }
}