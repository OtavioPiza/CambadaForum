package piza.otavio.cambadaforum.exceptions;

/**
 * Exception that is the parent to all of the project's custom exceptions
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-21
 */
public class CambadaForumException extends Exception{
	private static final long serialVersionUID = 1L; // Serial UID
	protected final String message;
	
	CambadaForumException(String message) {
		this.message = message;
	}
}
