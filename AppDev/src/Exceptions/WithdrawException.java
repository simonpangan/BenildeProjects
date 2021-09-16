package Exceptions;

public class WithdrawException extends Exception{

	private String message;
	
	
	public WithdrawException(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
