package bank.loan;

import bank.MessageHandler;

/**
 * Using the Chain of Responsibility pattern, we can pass a loan through the Manager, to the President
 * if his authorization is necessary on a certain loan. The nextHandler will pass the loan on if it is out of the
 * Branch Manager's range.
 *
 */
public abstract class LoanHandler {

	private LoanHandler nextHandler;

	public abstract double getLimit();

	public boolean authorize(LoanRequest request) throws Exception {
		double amount = request.getAmount();
        if (amount <= getLimit()) {
            MessageHandler.print("A " + getType() + " has authorized the loan request of $" + request.getAmount());
            return true;
        } else {
        	return getNextHandler().authorize(request);
        }
	}
	
    public LoanHandler getNextHandler() throws Exception {
    	if(nextHandler == null){
    		throw new Exception("No bank employee could authorize the loan request");
    	}
        return nextHandler;
    }
    public void setNextHandler(LoanHandler handler) {
        nextHandler = handler;
    }
    
    public abstract String getType();
}
