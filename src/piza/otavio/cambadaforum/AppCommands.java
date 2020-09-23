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
	
	private String command;
	private String description;
	
	AppCommands(String command, String description) {
		this.command = command;
		this.description = description;
	}
	public String getCommand() {
		return command;
	}
	public String getDescription() {
		return description;
	}
} // End AppCommands