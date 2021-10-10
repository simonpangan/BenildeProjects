package Exception;

public class LoginException extends Exception{

	private String message;
	
	
	public LoginException(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
}