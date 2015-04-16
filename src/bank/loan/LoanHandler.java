package bank.loan;

/**
 * Using the Chain of Responsibility pattern, we can pass a loan through the Manager, to the President
 * if his authorization is necessary on a certain loan. The nextHandler will pass the loan on if it is out of the
 * Branch Manager's range.
 *
 */
public abstract class LoanHandler {

	private LoanHandler nextHandler;
  
    public abstract boolean authorize(LoanRequest request) throws Exception;
    public LoanHandler getNextHandler() throws Exception {
    	if(nextHandler == null){
    		throw new Exception("There is no next handler");
    	}
        return nextHandler;
    }
    public void setNextHandler(LoanHandler handler) {
        nextHandler = handler;
    }
}
