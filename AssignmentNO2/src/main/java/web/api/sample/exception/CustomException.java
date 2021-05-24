package web.api.sample.exception;

public class CustomException extends Exception  {

	
	/**
	 * extends exception, meaning CustomException can provide flexibility to add attributes and methods that are not part of a standard java exception.
	 * (https://stackify.com/java-custom-exceptions/)
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}
}