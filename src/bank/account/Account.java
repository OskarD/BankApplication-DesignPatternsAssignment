package bank.account;

import java.util.LinkedList;
import java.util.Map;

import bank.card.Card;

public abstract class Account {
	private static int uniqueAccountNumber = 0;
	private int accountNumber;
	
	private LinkedList<Card> cards = new LinkedList<Card>();
	private boolean accountOpen = true;
	private double balance;
	private String ownerName;
	
	/**
	 * Constructor
	 * @param ownerName Name of the account owner
	 */
	public Account(String ownerName) {
		this.ownerName = ownerName;
		setUniqueAccountNumber();
	}
	
	/**
	 * Constructor
	 * @param ownerName Name of the account owner
	 * @param balance Initial account balance
	 */
	public Account(String ownerName, double balance) {
		this.ownerName = ownerName;
		setBalance(balance);
		setUniqueAccountNumber();
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
	
	/**
     * Deposits (Adds) money to the account balance
     * @param amount The amount of dollars to be deposited
     * @throws BankAccountException if the account is closed
     * @throws BankAccountException if given an invalid amount
     */
    public abstract void deposit(double amount) throws BankAccountException;
    
    /**
     * Withdraws (Adds) money to the account balance
     * @param amount The amount of dollars to be withdrawn
     * @throws BankAccountException if the account is closed
     * @throws BankAccountException if given an invalid amount
     */
    public abstract void withdraw(double amount) throws BankAccountException;
    
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
        
}
