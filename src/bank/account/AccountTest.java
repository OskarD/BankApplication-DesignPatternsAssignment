package bank.account;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void test() throws Exception {
		Account ac = CreateAccount.createAcc("Savings", "Tyler Test");
		ac.deposit(25);
		assertEquals(25, ac.getBalance(), 0.0000000001);
	}

}
