/**
 * 
 */
package piza.otavio.cambadaforum;

/**
 * Contains the set of commands available to control the WebApplication from the command line
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-20
 */
public enum AppCommands {
	CONFIGUREDATABASE("config", "configures the postgresql database"),
	HELP("help", "displays all available commands"),
	QUIT("quit", "closes the program"),
	RESETDATABASE("reset", "resets the postgresql database");
	
	private String command;		// Stores the command to use the functionality
	private String description;	// Stores the functionality description
	
	/**
	 * Constructor
	 * 
	 * @param command
	 * @param description
	 */
	AppCommands(String command, String description) {
		this.command = command;
		this.description = description;
	} // End AppCommands
	
	/**
	 * @return command
	 */
	public String getCommand() {
		return command;
	} // End getCommand()
	
	/**
	 * @return command functionality description
	 */
	public String getDescription() {
		return description;
	} // End getDescription()
} // End AppCommands