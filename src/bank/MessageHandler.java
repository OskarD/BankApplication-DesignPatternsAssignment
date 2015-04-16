package bank;

public class MessageHandler {
	/**
	 * Handles system messages
	 * 
	 * @param message
	 *            The message to handle
	 */
	public static void print(String message) {
		// This may be expanded or changed in the future
		System.out.println(message);
	}
	
	public static void print(double d) {
		print(Double.toString(d));
	}
}
