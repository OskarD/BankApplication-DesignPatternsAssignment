package bank.user;

import java.util.ArrayList;

import bank.account.Account;

public class User {
	
	private String
		username;

	private ArrayList<Account> accounts = new ArrayList<>();

	public User() {
	}
	
	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}
	
	public final ArrayList<Account> getAccounts() {
		return accounts;
	}

	public final void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	public final void addAccount(Account account) {
		this.accounts.add(account);
	}

}
