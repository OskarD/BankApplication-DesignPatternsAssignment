package bank.account.state;

import bank.account.Account;
import bank.account.BankAccountException;


public abstract class State {
	private Account context;

	public State(Account account) {
		setContext(account);
	}

	public State(State source) {
		setContext(source.getContext());
	}

	public Account getContext() {
		return context;
	}

	public void setContext(Account newAccount) {
		context = newAccount;
	}

	public State transitionState() {
		return null;
	}

	public static State InitialState(Account account) {
		return new NoTransactionFeeState(account);
	}
	
	public void deposit(double amount) {
		double balance = getContext().getBalance();

		getContext().setBalance(balance + amount);
		transitionState();
	}
	
	public void withdraw(double amount) throws BankAccountException {
		double balance = getContext().getBalance();

		getContext().setBalance(balance - amount);
		transitionState();
	}

}
