package piza.otavio.cambadaforum.exceptions;

/**
 * Exception thrown if there is not user with a given login on the database
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-21
 */
public class UserNotFoundException extends CambadaForumException {
	private static final long serialVersionUID = 1L; // Version UID
	
	public UserNotFoundException(String message) {
		super(message);
	}
	@Override
	public String getMessage() {
		return message;
	}
}
