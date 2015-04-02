package client;

import java.util.LinkedList;

import bank.account.Account;

public class Client implement AccountObserver {
	LinkedList<Account> accounts = new LinkedList<Account>();
}
