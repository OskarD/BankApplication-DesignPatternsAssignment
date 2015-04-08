import bank.account.Account;

public class State {
  private Account context;

  
   public State(Account account) {
    setContext(account);
  }

  public State(State source) {
    setContext(source.getContext());
  }
  
  public Account getContext() {
    return context;
  }

  public void setContext(Account newAccount) {
    context = newAccount;
  }

  public State transitionState() {
    return null;
  }

 

  public static State InitialState(Account account) {
    return new NoTransactionFeeState(account);
  }
  public boolean deposit(double amount) {
    double balance = getContext().getBalance();

    getContext().setBalance(balance + amount);
    transitionState();
    System.out.println("An amount " + amount +
                       " is deposited ");
    return true;
  }
  public boolean withdraw(double amount) {
    double balance = getContext().getBalance();

    getContext().setBalance(balance - amount);
    transitionState();
    System.out.println("An amount " + amount +
                       " is withdrawn ");
    return true;
  }

}
