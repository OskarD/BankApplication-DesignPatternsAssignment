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
	
	public Card createCard(String cardType) {
        if (cardType.equalsIgnoreCase("Debit")) {
        	card = new DebitCard();
            MessageHandler.print("A Debit Card has been created.");
        }   
        else if  (cardType.equalsIgnoreCase("Credit")) {
        	card = new CreditCard();
            MessageHandler.print("A Credit Card has been created.");
        }       
        
        return card;
    }
}
