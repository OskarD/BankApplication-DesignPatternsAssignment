package bank.account;

import bank.MessageHandler;


public class SavingAccount extends Account {

	public SavingAccount(String ownerName) {
		super(ownerName);
	}
	
	public SavingAccount(String ownerName, double amount) {
		super(ownerName, amount);
	}

	@Override
	public String getAccType() { return "Savings Account"; }
	
	@Override
	public void withdraw(double amount) throws BankAccountException {
		MessageHandler.print("Withdrawing money with your savings account costs an extra $2");
		
		super.withdraw(amount + 2.0);
	}
}
