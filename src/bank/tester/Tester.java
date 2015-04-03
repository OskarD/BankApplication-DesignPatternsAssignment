package bank.tester;
import bank.LoanRequest;
import bank.account.Account;
import bank.account.Chequing;
import bank.account.Saving;
import bank.account.transaction.Transaction;
import bank.account.transaction.TransactionFacade;
import bank.employee.BranchManager;
import bank.employee.BranchPresident;


public class Tester {
	 private BranchManager branchManager;
	 private BranchPresident branchpresident;
	 
	 /**
	  * Demonstrates the abilities of our system
	  * @param args
	  */
	 public static void main(String[] args) {
		 System.out.println("[[[[[ Demonstrating system functionality ]]]]]\n\n");
		 demoLoanRequest();
		 demoTransactions();
	 }
	 
	 public static void demoLoanRequest() {
		 System.out.println("---------- Demonstrating loan requests\n");
		 BranchManager branchManager = new BranchManager();
		 BranchPresident branchpresident = new BranchPresident();
		 
		 branchManager.setNextHandler(branchpresident);
		 
		 LoanRequest request = new LoanRequest("Loan for ", 5000);
	     branchManager.authorize(request);
	 }
	 
	 public static void demoTransactions() {
		 System.out.println("---------- Demonstrating transactions\n");
		 Account 
		 	account1 = new Chequing("Mister Master", 1_000_000),
		 	account2 = new Saving("Poor Johnny", 15);

		 System.out.println("Demonstrating approved transaction:");
		 Transaction transaction = TransactionFacade.performTransaction(account1, account2, 9.99);
		 System.out.println("\n" + transaction);
		 
		 System.out.println("Demonstrating disapproved transaction:");
		 transaction = TransactionFacade.performTransaction(account2, account1, 30.00);
		 System.out.println("\n" + transaction);
	 }
}
