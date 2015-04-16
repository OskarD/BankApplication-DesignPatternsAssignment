package bank.card;

import bank.MessageHandler;

public class CreateCard {
	private static volatile CreateCard createCardInst;
	private static Card card;
	
	private CreateCard() { }
	
	public static CreateCard getCreateCardInstance(){
		if (null == card) {
	        synchronized (CreateCard.class){
	            if (null == createCardInst) {
	            	createCardInst = new CreateCard(); 
	              }
	           }
	        }
	        return createCardInst;
	}
	
	public Card createCard(String cardType, String owner) throws Exception {
        if (cardType.equalsIgnoreCase("Debit")) {
        	card = new DebitCard(owner);
            MessageHandler.print("A Debit Card has been created.");
        }   
        else if  (cardType.equalsIgnoreCase("Credit")) {
        	card = new CreditCard(owner);
            MessageHandler.print("A Credit Card has been created.");
        }else{
			throw new Exception("Invalid type of card provided");    
        }
        return card;
    }
}
