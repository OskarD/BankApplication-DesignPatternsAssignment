package bank.card;

import java.util.Calendar;

public class CreditCard extends Card{

	public CreditCard(String owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}
	/* ToDo: Add Appropriate Method */
	
	@Override
	public void setExpDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, 2);
		getExpDate().setMonth(c.MONTH);
		getExpDate().setYear(c.YEAR);
    }

	@Override
	public String getType() {
		return "Credit Card";
	}

}
