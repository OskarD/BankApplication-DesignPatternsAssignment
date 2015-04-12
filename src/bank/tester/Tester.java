package bank.tester;
import bank.MessageHandler;
import bank.account.Account;
import bank.account.ChequingAccount;
import bank.account.SavingAccount;
import bank.account.transaction.Transaction;
import bank.account.transaction.TransactionFacade;
import bank.employee.BranchManager;
import bank.employee.BranchPresident;
import bank.loan.LoanRequest;


public class Tester {
	 private BranchManager branchManager;
	 private BranchPresident branchpresident;
	 
	 /**
	  * Demonstrates the abilities of our system
	  * @param args
	  */
	 public static void main(String[] args) {
		 MessageHandler.print("[[[[[ Demonstrating system functionality ]]]]]\n\n");
		 demoLoanRequest();
		 demoTransactions();
	 }
	 
	 public static void demoLoanRequest() {
		 MessageHandler.print("---------- Demonstrating loan requests\n");
		 BranchManager branchManager = new BranchManager();
		 BranchPresident branchpresident = new BranchPresident();
		 
		 branchManager.setNextHandler(branchpresident);
		 
		 LoanRequest request = new LoanRequest("Loan for ", 5000);
	     branchManager.authorize(request);
	 }
	 
	 public static void demoTransactions() {
		 MessageHandler.print("---------- Demonstrating transactions\n");
		 Account 
		 	account1 = new ChequingAccount("Mister Master", 1_000_000),
		 	account2 = new SavingAccount("Poor Johnny", 15);

		 MessageHandler.print("Demonstrating approved transaction:");
		 Transaction transaction = TransactionFacade.performTransaction(account1, account2, 9.99);
		 MessageHandler.print("\n" + transaction);
		 
		 MessageHandler.print("Demonstrating disapproved transaction:");
		 transaction = TransactionFacade.performTransaction(account2, account1, 30.00);
		 MessageHandler.print("\n" + transaction);
	 }
}
