package piza.otavio.cambadaforum.exceptions;

/**
 * Exception that is the parent to all of the project's custom exceptions
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-21
 */
public class CambadaForumException extends Exception{
	private static final long serialVersionUID = 1L; // Serial UID
	protected final String message; // Stores exception message
	
	/**
	 * Constructor that allows for the user to add a message to the exception
	 * 
	 * @param message that will be part of the exception
	 */
	CambadaForumException(String message) {
		this.message = message;
	} // CambadaForumException()
	
	/**
	 * Gets the message from the exception
	 * 
	 * @return the message from the exception
	 */
	@Override
	public String getMessage() {
		return message;
	} // getMessage()
} // CambadaForumException
