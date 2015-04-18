package bank.account;

import java.util.LinkedList;
import java.util.Map;

import bank.account.state.State;
import bank.card.Card;

/**
 *  Using the Template pattern for the Account class, we can make sure that any parameters that need to be used for
 *  any type of account are not duplicated in multiple sub classes. Minimum balances and Fees can apply to any
 *  account, so we make sure not to duplicate these fields for each individual account type.
 *
 */
public abstract class Account {
	public static final double MIN_BALANCE = 2000.00;
	public static final double OVERDRAW_LIMIT = -1000.00;

	public static final double TRANS_FEE_NORMAL = 2.00;
	public static final double TRANS_FEE_OVERDRAW = 5.00;
	
	private static int uniqueAccountNumber = 100000;
	private int accountNumber;
	
	private LinkedList<Card> cards = new LinkedList<Card>();
	private boolean accountOpen = true; // TODO replace with state
	private double balance;
	private String ownerName;
	private State state;

	/**
	 * Constructor
	 * @param ownerName Name of the account owner
	 */
	public Account(String ownerName) {
		this.ownerName = ownerName;
		setUniqueAccountNumber();
		setState(State.InitialState(this));
	}
	
	/**
	 * Constructor
	 * @param ownerName Name of the account owner
	 * @param balance Initial account balance
	 */
	public Account(String ownerName, double balance) {
		this(ownerName);
		setBalance(balance);
	}

    private void setUniqueAccountNumber() {
    	this.accountNumber = ++uniqueAccountNumber;
    }
    
    public final int getAccountNumber() {
		return accountNumber;
	}

	public final LinkedList<Card> getCards() {
		return cards;
	}

	public final void addCard(Card card) {
		cards.add(card);
	}
	
	public final void removeCard(Card card) {
		cards.remove(card);
	}
	
	public final boolean isAccountOpen() {
		return accountOpen;
	}
	
	public final void open() {
		this.accountOpen = true;
	}
	
	public final void close() {
		this.accountOpen = false;
	}
	
	public final String getOwnerName() {
		return ownerName;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public final double getBalance() {
		return this.balance;
	}
	
	public final State getState() {
		return state;
	}

	public final void setState(State state) {
		this.state = state;
	}
	
	/**
     * Deposits (Adds) money to the account balance
     * @param amount The amount of dollars to be deposited
     * @throws BankAccountException if the account is closed
     * @throws BankAccountException if given an invalid amount
     */
    public void deposit(double amount) throws BankAccountException {
    	if(amount <= 0 )
			throw new BankAccountException("Invalid amount", BankAccountException.INVALID_AMOUNT);
		
    	getState().deposit(amount);
    }
    
    /**
     * Withdraws (Adds) money to the account balance
     * @param amount The amount of dollars to be withdrawn
     * @throws BankAccountException if the account is closed
     * @throws BankAccountException if given an invalid amount
     */
    public void withdraw(double amount) throws BankAccountException {
    	if(amount <= 0)
			throw new BankAccountException("Invalid amount", BankAccountException.INVALID_AMOUNT);
		
    	getState().withdraw(amount);
    }
    
    @Override
    public String toString() {
    	String output = 
    			"[Account]\n" +
    			"Account#: " + accountNumber + "\n" +
    			"Balance: $" + balance + "\n" +
    			"Owner: " + ownerName + "\n" +
    			"Account status: ";
    	
    	if(isAccountOpen())
    		output += "Open";
    	else
    		output += "Closed";
    	
    	return output;
    }
    
    public abstract String getType();
        
}
