package bank.employee;

import static org.junit.Assert.*;

import org.junit.Test;

import bank.loan.LoanRequest;

public class BranchManagerTest {

	@Test
	public void test() {
		BranchManager bM = new BranchManager();
		LoanRequest request = new LoanRequest("test amount $", 7000);
		try {
			assertTrue("this boolean is incorrect", bM.authorize(request));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
