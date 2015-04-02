package bank;

public class BranchManager extends LoanHandler {
	
    static double LIMIT = 8000;    

	@Override
	public boolean authorize(LoanRequest request) {
		// TODO Auto-generated method stub
		 double amount = request.getAmount();
	        if (amount <= LIMIT) {
	            System.out.println(" The Branch Manager has authorized the Loan Request of: " + request);
	            return true;
	        } else {
	            return getNextHandler().authorize(request);
	        }
        }
     }


