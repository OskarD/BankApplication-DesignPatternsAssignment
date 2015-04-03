package bank.account.transaction;

public class BankTransactionException extends Exception {
	private static final long serialVersionUID = -3875913562659952800L;

	public static final int
		SENDING_ACCOUNT_FAIL 	= 1,
		RECEIVING_ACCOUNT_FAIL 	= 2,
		ALREADY_EXECUTED		= 3;
	
	private final int
		code;

	public BankTransactionException(String message) {
		super(message);
		this.code = 0;
	}
	
	public BankTransactionException(String message, int code) {
		super(message);
		this.code = code;
	}

	public final int getCode() {
		return code;
	}

}
