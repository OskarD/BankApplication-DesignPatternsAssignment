package tester;
import bank.LoanRequest;
import bank.employee.BranchManager;
import bank.employee.BranchPresident;


public class Tester {
	/**
	 * TODO Write code for testing all parts
	 * @author Oskar
	 */	
	 private BranchManager branchManager;
	 private BranchPresident branchpresident;
	 
	 public static void main(String[] args) {
		 
		 Tester tester = new Tester();
		 tester.authorizationFlow();
		 LoanRequest request = new LoanRequest("Loan for ", 5000);
	     tester.branchManager.authorize(request);
	 }
	 
	 public void authorizationFlow() {       
		 branchManager.setNextHandler(branchpresident);
	 }
}
