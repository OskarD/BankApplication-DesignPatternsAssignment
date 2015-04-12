package bank.account.state;

import bank.account.Account;
import bank.account.BankAccountException;

public class NoTransactionFeeState extends State {
	public NoTransactionFeeState(Account account) {
		super(account);
	}

	public NoTransactionFeeState(State source) {
		super(source);
	}
	
	public void deposit(double amount) {
		super.deposit(amount);
	}
	
	public void withdraw(double amount) throws BankAccountException {
		double balance = getContext().getBalance();

		if ((balance - amount) <= Account.OVERDRAW_LIMIT)
			throw new BankAccountException("Insufficient funds", BankAccountException.INSUFFICIENT_FUNDS);
	
		super.withdraw(amount);
	}

	public State transitionState() {
		double balance = getContext().getBalance();
		
		if (balance < 0)
			getContext().setState(new OverDrawnState(this));
		else if (balance < Account.MIN_BALANCE)
			getContext().setState(new TransactionFeeState(this));
		
		return getContext().getState();
	}

}

