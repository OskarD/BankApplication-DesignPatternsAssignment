package bank.account.transaction;

import bank.MessageHandler;
import bank.account.Account;

public class TransactionFacade {
	/**
	 * Performs a transaction after printing an ad
	 * @param sendingAccount The Account sending money
	 * @param receivingAccount The account receiving money
	 * @param amount The amount of dollars to be transferred
	 * @return The transaction object
	 */
	public static Transaction performTransaction(Account sendingAccount, Account receivingAccount, double amount) {
		MessageHandler.print("Performing transaction of $" + amount + " from account# " + sendingAccount.getAccountNumber() + " to account# " + receivingAccount.getAccountNumber());
		MessageHandler.print("--- Advertisement ---");
		MessageHandler.print("This transaction was brought to you by:");
		MessageHandler.print(TransactionAd.getAd());
		
		Transaction transaction = new Transaction(sendingAccount, receivingAccount, amount);
		
		try {
			transaction.execute();
			
			MessageHandler.print("Transaction completed");
		} catch(Exception e) {
			MessageHandler.print("Transaction error: " + e.getMessage());
		}
		
		return transaction;
	}
}
