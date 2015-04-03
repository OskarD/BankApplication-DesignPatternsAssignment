package bank.account.transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import bank.account.Account;
import bank.account.BankAccountException;

public class Transaction {
	private static final DateFormat 
		df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	private final Account
		sendingAccount,
		receivingAccount;
	
	private final double
		amount; // Cannot be changed, a new transaction needs to be initiated to change the amount
	
	private Date
		date; // Will be set at the time of the transaction execution
	
	private boolean
		executed = false;
	
	public Transaction(Account sendingAccount, Account receivingAccount, double amount) {
		this.sendingAccount = sendingAccount;
		this.receivingAccount = receivingAccount;
		this.amount = amount;
	}
	
	/**
	 * Checks if the Transaction has been executed or not
	 * @return true if Transaction has been successfully executed, false if not
	 */
	public boolean wasExecuted() {
		return executed;
	}
	
	/**
	 * @throws BankTransactionException if the Transaction has already been executed
	 * @throws BankTransactionException if the sending account cannot send the required amount
	 * @throws BankTransactionException if the receiving account cannot receive the required amount
	 * @throws BankAccountException if the sending account cannot get its money back after the receiving account fails the transaction
	 */
	public void execute() throws BankTransactionException, BankAccountException {
		if(executed)
			throw new BankTransactionException("This transaction has already been executed", BankTransactionException.ALREADY_EXECUTED);
		
		// Make sure both accounts can perform the transaction
		try {
			sendingAccount.withdraw(amount);
		} catch(BankAccountException e) {
			throw new BankTransactionException("Sending account was unable to complete transaction", BankTransactionException.SENDING_ACCOUNT_FAIL);
		}
		
		try {
			receivingAccount.deposit(amount);
		} catch(BankAccountException e) {
			// Give money back to sending account before throwing exception
			sendingAccount.deposit(amount);
			
			throw new BankTransactionException("Receiving account was unable to complete transaction", BankTransactionException.RECEIVING_ACCOUNT_FAIL);
		}
		
		// Log date
		this.date = Calendar.getInstance().getTime(); ;
		
		executed = true;
	}
	
	@Override
	public String toString() {
		String output = 
				"[Transaction]\n" +
				"Sending account#: " + sendingAccount.getAccountNumber() + "\n" +
				"Receiving account#: " + receivingAccount.getAccountNumber() + "\n" +
				"Amount: $" + amount + "\n";
		
		if(wasExecuted())
			output += "Executed at " + df.format(date) + "\n";
		else
			output += "Not executed\n";
		
		output += "[End of transaction]";
		
		return output;
	}
}
