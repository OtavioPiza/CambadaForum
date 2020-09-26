package piza.otavio.cambadaforum.exceptions;

/**
 * Exception thrown if the program is unable to get the users from the database
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-21
 */
public class UnableToGetUsersException extends CambadaForumException {
	private static final long serialVersionUID = 1L; // Version UID
	
	/**
	 * Constructor that allows for the user to add a message to the exception
	 * 
	 * @param message that will be part of the exception
	 */
	public UnableToGetUsersException(String message) {
		super(message);
	} // UnableToGetUsersException()
} // UnableToGetUsersException
