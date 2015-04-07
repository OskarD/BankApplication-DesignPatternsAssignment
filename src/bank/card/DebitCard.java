package bank.card;

import java.sql.Date;
import java.util.Calendar;

public class DebitCard extends Card{

	public DebitCard(String owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}
	/* ToDo: Add Appropriate Method */
	
	@Override
	public void setExpDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, 5);
		getExpDate().setMonth(c.MONTH);
		getExpDate().setYear(c.YEAR);
    }

}
