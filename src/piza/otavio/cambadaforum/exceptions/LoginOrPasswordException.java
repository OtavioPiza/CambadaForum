package piza.otavio.cambadaforum.exceptions;

/**
 * Exception thrown if there is not user with a given login on the database or password is incorrect
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-21
 */
public class LoginOrPasswordException extends CambadaForumException {
	private static final long serialVersionUID = 1L;	// Version UID
	
	/**
	 * Constructor that allows for the user to add a message to the exception
	 * 
	 * @param message that will be part of the exception
	 */
	public LoginOrPasswordException(String message) {
		super(message);
	}
}
