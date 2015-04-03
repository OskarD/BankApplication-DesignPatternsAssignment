package bank.account.transaction;

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
		System.out.println("Performing transaction of $" + amount + " from account# " + sendingAccount.getAccountNumber() + " to account# " + receivingAccount.getAccountNumber());
		System.out.println("--- Advertisement ---");
		System.out.println("This transaction was brought to you by:");
		System.out.println(TransactionAd.getAd());
		
		Transaction transaction = new Transaction(sendingAccount, receivingAccount, amount);
		
		try {
			transaction.execute();
			
			System.out.println("Transaction completed");
		} catch(Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}
		
		return transaction;
	}
}
