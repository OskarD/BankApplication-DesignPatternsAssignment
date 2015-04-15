package bank.account;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreateAccountTest {

	@Test
	public void test() throws Exception {
		assertNotNull("Savings Account Not Created", CreateAccount.createAcc("Savings", "Tyler Serio"));
		assertNotNull("Chequing Account Not Created", CreateAccount.createAcc("Chequing", "Tyler Test")); 
	}

}
