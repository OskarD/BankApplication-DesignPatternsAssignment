package bank.account;


public class ChequingAccount extends Account {

	public ChequingAccount(String ownerName) {
		super(ownerName);
	}
	
	public ChequingAccount(String ownerName, double amount) {
		super(ownerName, amount);
	}

}
