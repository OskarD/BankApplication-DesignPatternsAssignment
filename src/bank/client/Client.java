package bank.client;

import java.util.LinkedList;

import bank.account.Account;
import bank.account.AccountObserver;

public class Client implements AccountObserver {
	LinkedList<Account> accounts = new LinkedList<Account>();
}
