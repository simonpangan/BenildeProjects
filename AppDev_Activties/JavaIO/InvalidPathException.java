package Activity;

public class InvalidPathException extends Exception{

	private String message;
	
	
	public InvalidPathException(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
