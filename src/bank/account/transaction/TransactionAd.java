package bank.account.transaction;

import java.util.ArrayList;
import java.util.Random;

public class TransactionAd {
	private static ArrayList<String> ads = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;

	{
		add("Lottery Company: Yes, Winning IS Everything");
		add("Facebook: We don’t charge an arm and leg because we’re just collecting souls");
		add("Google: Life has become one giant game of hide and seek");
		add("Twitter: No meds needed when you go viral");
		add("NHL: Where hitting is fitting while people are watching and sitting");
		add("Any News Station: Where staring is polite");
	}};
	
	/**
	 * Gets a randomly selected ad from the ArrayList of ads
	 * @return An ad
	 */
	public static String getAd() {
		Random randomGenerator = new Random();
		return ads.get( randomGenerator.nextInt(ads.size()) );
	}
}
