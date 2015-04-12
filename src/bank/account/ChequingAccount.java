package bank.account;


public class ChequingAccount extends Account {

	public ChequingAccount(String ownerName) {
		super(ownerName);
	}
	
	public ChequingAccount(String ownerName, double balance) {
		super(ownerName, balance);
	}

	@Override
	public void deposit(double amount) throws BankAccountException {
		if(!isAccountOpen())
			throw new BankAccountException("Account is closed", BankAccountException.ACCOUNT_CLOSED);
		
		if(amount < 0 )
			throw new BankAccountException("Invalid amount", BankAccountException.INVALID_AMOUNT);
		
		setBalance(getBalance() + amount);
	}

	@Override
	public void withdraw(double amount) throws BankAccountException {
		if(!isAccountOpen())
			throw new BankAccountException("Account is closed", BankAccountException.ACCOUNT_CLOSED);
		
		if(amount < 0 )
			throw new BankAccountException("Invalid amount", BankAccountException.INVALID_AMOUNT);
		
		if(amount > getBalance())
			throw new BankAccountException("Insufficient funds", BankAccountException.INSUFFICIENT_FUNDS);
		
		setBalance(getBalance() - amount);
	}

}
