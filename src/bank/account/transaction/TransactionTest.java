package bank.account.transaction;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import bank.account.*;

public class TransactionTest {

	Account ac1 = new ChequingAccount("Sender",100), 
			ac2= new ChequingAccount("Recievee",100);
	
	//@Ignore
	
	@Test
	public void test() throws Exception{
		System.out.println(ac1.getOwnerName() +" has $" +ac1.getBalance());
		System.out.println(ac2.getOwnerName() +" has $" +ac2.getBalance());
		assertNotNull("Money Not sent",TransactionFacade.performTransaction(ac1,ac2, 70));

		System.out.println(ac1.getOwnerName() +" has $" +ac1.getBalance());
		System.out.println(ac2.getOwnerName() +" has $" +ac2.getBalance());
	}
	
}
