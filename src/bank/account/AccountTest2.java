package bank.account;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest2 {

	@Test
	public void test() throws Exception {
		Account ac = CreateAccount.createAcc("Savings", "Tyler Test");
		ac.deposit(50);
		ac.withdraw(25);
		System.out.println(ac.getBalance());
		assertEquals(23, ac.getBalance(), 0.00000001);
	}

}
