package bank.loan;

//COR
public abstract class LoanHandler {

	private LoanHandler nextHandler;
  
    public abstract boolean authorize(LoanRequest request);
    public LoanHandler getNextHandler() {
        return nextHandler;
    }
    public void setNextHandler(LoanHandler handler) {
        nextHandler = handler;
    }
}
