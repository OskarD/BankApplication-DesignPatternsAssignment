package bank.employee;

import bank.MessageHandler;
import bank.loan.LoanHandler;
import bank.loan.LoanRequest;

public class BranchPresident extends LoanHandler {

	@Override
	public String getType() {
		return "Branch President";
	}

	@Override
	public double getLimit() {
		return 10_000;
	}
}
