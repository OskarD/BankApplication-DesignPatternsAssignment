package bank.account;
import java.util.HashMap;


public class Chequing extends Account {

	
	public Chequing() {
		
        this.accountNumber = ++uniqueID;
        this.balance = 0;
        
        if (this.list == null) {
            this.list = new HashMap<String, Double>();
        }
    }
    
    public Chequing(double amountt) {
    	
        this.balance = amountt;
        this.accountNumber = ++uniqueID;
        
        if (this.list == null) {
            this.list = new HashMap <String, Double>();
        }
    }
	
	
	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		this.balance += amount;	
	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if (this.balance >= amount) 
		{		
            this.balance = this.balance - amount;
        } 
	}

	@Override
	public Double getBalance() {
		// TODO Auto-generated method stub
		Double newBalance = balance;
        return newBalance;
	}

	@Override
	public void AccountInfo() {
		// TODO Auto-generated method stub
		 double amt = balance;
	     System.out.println("Account Number:\t" + accountNumber + "\nAccount Balance: $" + amt);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 Double amt = balance;
	     String string2 = "Account Number:\t" + accountNumber + "\nAccount Balance: $" + amt;
	     return string2;
	}
}
