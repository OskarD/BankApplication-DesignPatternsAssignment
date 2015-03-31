public class AccountObserver{

Account account = new Account();

public AccountObserver(Account acc){
this.account = acc;

public void update(double newBal){
  this.account.setBalance(newBal);
}


}
