package bank.card;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreateCardTest {

	@Test
	public void test() {
		assertNotNull("Debit Card was not created", CreateCard.getCreateCardInstance().createCard("Debit", "Tyler Test"));
		assertNotNull("Credit Card was not created", CreateCard.getCreateCardInstance().createCard("Credit", "Tyler Test"));
		
	}

}
