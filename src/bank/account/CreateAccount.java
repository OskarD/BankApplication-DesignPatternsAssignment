package bank.account;

import bank.MessageHandler;


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


