import bank.account.Account;

public class TransactionFeeState extends State {

  public TransactionFeeState(Account account) {
    super(account);
  }
  public TransactionFeeState(State source) {
    super(source);
  }

  public State transitionState() {
    double balance = getContext().getBalance();
    if (balance < 0) {
      getContext().setState(new OverDrawnState(this));
    } else {
      if (balance >= Account.MIN_BALANCE) {
        getContext().setState(
          new NoTransactionFeeState(this));
      }
    }
    return getContext().getState();
  }
  public boolean deposit(double amount) {
    double balance = getContext().getBalance();

    getContext().setBalance(balance -
        Account.TRANS_FEE_NORMAL);
    System.out.println(
      "Transaction Fee was charged due to " +
      "account status " +
      "(less than minimum balance)");
    return super.deposit(amount);
  }
  public boolean withdraw(double amount) {
    double balance = getContext().getBalance();

    if ((balance - Account.TRANS_FEE_NORMAL -
         amount) > Account.OVERDRAW_LIMIT) {
      getContext().setBalance(balance -
          Account.TRANS_FEE_NORMAL);
      System.out.println(
        "Transaction Fee was charged due to " +
        "account status " +
        "(less than minimum balance)");
      return super.withdraw(amount);
    } else {
      System.out.println(
        Account.ERR_OVERDRAW_LIMIT_EXCEED);
      return false;
    }

  }


}
