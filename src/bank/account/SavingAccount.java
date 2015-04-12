package bank.account;


public class SavingAccount extends Account {

	public SavingAccount(String ownerName) {
		super(ownerName);
	}
	
	public SavingAccount(String ownerName, double amount) {
		super(ownerName, amount);
	}
}
