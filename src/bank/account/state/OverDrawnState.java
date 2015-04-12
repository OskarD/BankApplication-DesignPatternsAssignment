package bank.account.state;

import bank.MessageHandler;
import bank.account.Account;
import bank.account.BankAccountException;

public class OverDrawnState extends State {
	private static final String OVERDRAWN_MESSAGE = "A transaction fee of $" + Account.TRANS_FEE_OVERDRAW + " was charged due to account status (Overdrawn)";

	public OverDrawnState(Account account) {
		super(account);
		alertAccountHolder();
	}

	public OverDrawnState(State source) {
		super(source);
		alertAccountHolder();
	}

	public void alertAccountHolder() {
		MessageHandler.print("Attention: Your Account is Overdrawn");
	}

	public State transitionState() {
		double balance = getContext().getBalance();
		if (balance >= Account.MIN_BALANCE)
			getContext().setState(new NoTransactionFeeState(this));
		else if (balance >= 0)
			getContext().setState(new TransactionFeeState(this));

		return getContext().getState();
	}

	public void deposit(double amount) {
		double balance = getContext().getBalance();

		getContext().setBalance(balance - Account.TRANS_FEE_OVERDRAW);
		MessageHandler.print(OVERDRAWN_MESSAGE);
		super.deposit(amount);
	}

	public void withdraw(double amount) throws BankAccountException {
		double balance = getContext().getBalance();

		if ((balance - Account.TRANS_FEE_OVERDRAW -	amount) > Account.OVERDRAW_LIMIT)
			throw new BankAccountException("Overdraw limit has been exceeded", BankAccountException.OVERDRAW_LIMIT_EXCEEDED);

		getContext().setBalance(balance - Account.TRANS_FEE_OVERDRAW);
		MessageHandler.print(OVERDRAWN_MESSAGE);
		
		super.withdraw(amount);
	}

}
