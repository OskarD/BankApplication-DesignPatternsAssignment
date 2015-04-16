package bank.account.transaction;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import bank.MessageHandler;
import bank.account.*;

public class TransactionTest {

	Account ac1 = new ChequingAccount("Sender",100), 
			ac2= new ChequingAccount("Recievee",100);
	
	//@Ignore
	
	@Test
	public void test() throws Exception{
		MessageHandler.print(ac1.getOwnerName() +" has $" +ac1.getBalance());
		MessageHandler.print(ac2.getOwnerName() +" has $" +ac2.getBalance());
		assertNotNull("Money Not sent",TransactionFacade.performTransaction(ac1,ac2, 70));

		MessageHandler.print(ac1.getOwnerName() +" has $" +ac1.getBalance());
		MessageHandler.print(ac2.getOwnerName() +" has $" +ac2.getBalance());
	}
	
}
