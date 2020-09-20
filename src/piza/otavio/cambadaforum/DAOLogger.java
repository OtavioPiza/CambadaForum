package piza.otavio.cambadaforum;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class responsible for logging all database operations
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-20
 */
public class DAOLogger {
	
	private static String filePath = "C:/Users/otavi/Desktop/database_log.txt"; // Path to the database log
	// Date format template  
	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
	
	/**
	 * Set the path where the log is going to be saved
	 * 
	 * @param path to the log
	 */
	public static void setPath(String path) {
		filePath = path;
	} // End setPath(...)
	
	/**
	 * Private constructor to hide the implicit public one
	 */
	private DAOLogger() {
	}
	
	/**
	 * Translates an operation to a message with a time stamp
	 * 
	 * @param operation code to be interpreted
	 * @param id from the user that tried to perform the operation
	 */
	private static String interpret(int code, String id) {
		StringBuilder sb = new StringBuilder(); // String that contains the interpreted message
		
		sb.append("\n-=-=-= ").append(DTF.format(LocalDateTime.now())).append(" =-=-=-");
		sb.append('\n').append((code % 2 == 0) ? "Successful" : "Failed").append(" attempt to ");
		code /= 2;
		
		switch(code) {
			case 0:
				sb.append("register");
				break;
				
			case 1:
				sb.append("login");
				break;
				
			case 2:
				sb.append("create new topic");
				break;
				
			case 3:
				sb.append("post new comment");
				break;
				
			case 4:
				sb.append("edit topic");
				break;
				
			case 5:
				sb.append("display topics");
				break;
				
			case 6:
				sb.append("display user ranking");
				break;
				
			case 7:
				sb.append("unable to get user");
				break;
				
			default:
				sb.append("\nFailed to interpret message");
		}
		
		sb.append('\n').append("by: ").append(id);
		sb.append('\n').append("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-").append('\n');
		return sb.toString();
	} // End interpret()
	
	/**
	 * Logs to a system file a message of the operations performed on the forum's database
	 * 
	 * @param code
	 * @param user_id
	 */
	public static void log(int code, String id) {
		write(interpret(code, id));
	} // End constructor
	
	/**
	 * Writes a message to the FILEPATH file
	 * 
	 * @param message to be logged in a system file
	 */
	private static void write(String message) {
		File log = new File(filePath); // File for the database log
		boolean isNew = false;         // Stores if the file created is a new or an old one
		
		try {
			if (!log.exists()) {
				isNew = log.createNewFile();
			} // End if
			PrintWriter pw = new PrintWriter(new FileWriter(log, true));
			
			if (Boolean.TRUE.equals(isNew)) {
				pw.append("Database operations log:");
			} // End if
			pw.append(message);
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} // End try-catch block
	} // End write()
} // End DAOLogger