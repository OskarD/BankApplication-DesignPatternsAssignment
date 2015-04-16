package bank.employee;

import static org.junit.Assert.*;

import org.junit.Test;

import bank.loan.LoanRequest;

public class BranchPresidentTest {

	@Test
	public void test() {
		BranchPresident bP = new BranchPresident();
		LoanRequest request = new LoanRequest("test amount $", 9999);
		assertTrue("this boolean is incorrect", bP.authorize(request));
	}

}
