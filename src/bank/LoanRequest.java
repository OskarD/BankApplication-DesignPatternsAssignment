package bank;
//COR
public class LoanRequest {

    private String description;
    private double amount;
    
    public LoanRequest(String desc, double amt) {
    description = desc;
    amount = amt;
    }
    
    public double getAmount() {
    return amount;
    }
    
    public String toString() {
    return  description;
    }

}
