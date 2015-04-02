package client;

import java.util.LinkedList;

import bank.account.*;

public class Client implements AccountObserver {
	LinkedList<Account> accounts = new LinkedList<Account>();
}
