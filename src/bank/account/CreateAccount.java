package bank.account;

import bank.MessageHandler;

/**
 * Using the Singleton pattern, we make sure that there is only one instance of the CreateCard class instantiated.
 * We do this because this one object will be able to create as many cards as we have to create, for any client.
 *
 */
public class CreateAccount {

	public static Account createAcc(String accType, String ownerName) throws Exception {
		Account acc;
		
		if (accType.equalsIgnoreCase("Savings")) {
			acc = new SavingAccount(ownerName);
			MessageHandler.print("A Savings account has been created.");
		}   
		else if  (accType.equalsIgnoreCase("Chequing")) {
			acc = new ChequingAccount(ownerName);
			MessageHandler.print("A Chequing account has been created.");
		}
		else
			throw new Exception("Invalid type of account provided");

		return acc;
	}

}


