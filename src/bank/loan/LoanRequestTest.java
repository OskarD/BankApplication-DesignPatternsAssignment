package bank.loan;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoanRequestTest {

	@Test
	public void test() {
		LoanRequest lR = new LoanRequest("test", 100);
		assertEquals("amount loaned out is incorrect", 100, lR.getAmount(), 0.0000001);
		assertEquals("description is incorrect", "tesst", lR.toString());
	}

}
