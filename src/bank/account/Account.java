package bank.account;

import java.util.Map;

import bank.Transaction;

public abstract class Account implements Transaction {
    
    protected static int uniqueID = 0;
    
    protected double balance;
    protected int accountNumber; 
    protected Map list;

    
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract Double getBalance();
    public abstract void AccountInfo();
    
    public abstract String toString();
    
}
