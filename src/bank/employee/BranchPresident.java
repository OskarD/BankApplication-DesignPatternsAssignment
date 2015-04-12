package bank.employee;

import bank.MessageHandler;
import bank.loan.LoanHandler;
import bank.loan.LoanRequest;

public class BranchPresident extends LoanHandler {
	
    static double LIMIT = 10000;

	@Override
	public boolean authorize(LoanRequest request) {
		double amount = request.getAmount();
        if (amount <= LIMIT) {
            MessageHandler.print(" The Branch President has authorized the Loan Request of: " + request + amount);
            return true;
        } else {
        MessageHandler.print("Loan Rquest of: " + request +  " couldn't be authorized.\n " + "reason: Amount too large");
        return false;
        }
	}
}
