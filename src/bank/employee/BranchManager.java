package bank.employee;

import bank.MessageHandler;
import bank.loan.LoanHandler;
import bank.loan.LoanRequest;

public class BranchManager extends LoanHandler {
	
    static double LIMIT = 8000;    

	@Override
	public boolean authorize(LoanRequest request) {
		 double amount = request.getAmount();
	        if (amount <= LIMIT) {
	            MessageHandler.print(" The Branch Manager has authorized the Loan Request of: " + request + amount);
	            return true;
	        } else {
	            return getNextHandler().authorize(request);
	        }
        }
     }


