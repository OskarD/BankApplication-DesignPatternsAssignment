package bank.loan;

//COR
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
