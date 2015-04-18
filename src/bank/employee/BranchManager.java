package bank.employee;

import bank.MessageHandler;
import bank.loan.LoanHandler;
import bank.loan.LoanRequest;

public class BranchManager extends LoanHandler {

	@Override
	public String getType() {
		return "Branch Manager";
	}

	@Override
	public double getLimit() {
		return 8_000;
	}
 }


