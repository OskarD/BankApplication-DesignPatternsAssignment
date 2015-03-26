package bank.account;

import bank.Transaction;

public abstract class Account implements Transaction {
    
    protected static int uniqueID = 0;
    protected int accountNum;
    protected double balance;

    
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract String getBalance();
    public abstract void AccountInfo();
    
    public abstract String toString();
    
}
