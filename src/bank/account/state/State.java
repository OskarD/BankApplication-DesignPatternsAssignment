package bank.account.state;

import bank.account.Account;
import bank.account.BankAccountException;

/**
 * We used a state pattern for this class because certain transactions may require additional fees. The state pattern
 * allows us to set the context of the transaction and apply any fees that may be related to that account type
 *
 */
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
