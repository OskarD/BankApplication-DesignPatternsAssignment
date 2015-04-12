package bank.account.state;

import bank.MessageHandler;
import bank.account.Account;
import bank.account.BankAccountException;

public class TransactionFeeState extends State {

	private static final String OVERDRAWN_MESSAGE = "A transaction fee of $" + Account.TRANS_FEE_NORMAL + " was charged due to account status (Less than minimum balance)";
	
	public TransactionFeeState(Account account) {
		super(account);
	}
	
	public TransactionFeeState(State source) {
		super(source);
	}

	public State transitionState() {
		double balance = getContext().getBalance();
		
		if (balance < 0)
			getContext().setState(new OverDrawnState(this));
		
		else if (balance >= Account.MIN_BALANCE)
			getContext().setState(new NoTransactionFeeState(this));
		
		return getContext().getState();
	}
	
	public void deposit(double amount) {
		double balance = getContext().getBalance();

		getContext().setBalance(balance - Account.TRANS_FEE_NORMAL);
		MessageHandler.print(OVERDRAWN_MESSAGE);
		super.deposit(amount);
	}
	
	public void withdraw(double amount) throws BankAccountException {
		double balance = getContext().getBalance();

		if ((balance - Account.TRANS_FEE_NORMAL - amount) > Account.OVERDRAW_LIMIT)
			throw new BankAccountException("Overdraw limit exceeded", BankAccountException.OVERDRAW_LIMIT_EXCEEDED);
			
		getContext().setBalance(balance - Account.TRANS_FEE_NORMAL);
		MessageHandler.print(OVERDRAWN_MESSAGE);
		super.withdraw(amount);
	}

}
