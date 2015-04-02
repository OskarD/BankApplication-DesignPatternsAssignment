package bank.account;


public class CreateAccount {

	 private static volatile CreateAccount createAccInst;
	    private Account acc;
	   
	    
	    private CreateAccount() {
	        
	    }
	    
	 public static CreateAccount getCreateAccountInstance() {
	    if (null == createAccInst) {
	        synchronized (CreateAccount.class){
	            if (null == createAccInst) {
	              createAccInst = new CreateAccount(); 
	              }
	           }
	        }
	        return createAccInst;
	      }
	 
	 public Account createAcc(String accType) {
	        if (accType.equalsIgnoreCase("Savings")) {
	            acc = new Saving();
	            System.out.println("A Savings account has been created.");
	        }   
	        else if  (accType.equalsIgnoreCase("Chequing")) {
	        	acc = new Chequing();
	            System.out.println("A Chequing account has been created.");
	        }       
	        
	        return acc;
	    }

   }

 
