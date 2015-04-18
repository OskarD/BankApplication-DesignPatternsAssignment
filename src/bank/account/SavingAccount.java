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
	public void withdraw(double amount) throws BankAccountException {
		MessageHandler.print("Withdrawing money with your savings account costs an extra $2");
		
		super.withdraw(amount + 2.0);
	}

	@Override
	public String getType() {
		return "Saving";
	}
	
}
