package bank.account;

public class BankAccountException extends Exception {
	private static final long serialVersionUID = 8941292354142792001L;

	public static final int
		INSUFFICIENT_FUNDS = 1,
		ACCOUNT_CLOSED = 2,
		INVALID_AMOUNT = 3;
	
	private final int
		code;

	public BankAccountException(String message) {
		super(message);
		this.code = 0;
	}
	
	public BankAccountException(String message, int code) {
		super(message);
		this.code = code;
	}

	public final int getCode() {
		return code;
	}

}
