package piza.otavio.cambadaforum;

import java.util.Scanner;

/**
 * Only class that has a main method used to run code
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 13th 2020
 */
public class App {

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		AppCommands[] commands = AppCommands.values();
		boolean keepRunning = true;
		
		System.out.println("Welcome to the CambadaForum configuration tool!");
		System.out.println("Here are the commands available to you:\n");
		
		for (AppCommands command : commands) {
			System.out.println(command.getCommand() + " : " + command.getDescription());
		}
		System.out.println();

		try (Scanner sc = new Scanner(System.in)) {
			
			while(keepRunning) {
				
				switch(sc.nextLine()) {
				
				case "config":
					break;
					
				case "reset":
					break;
				
				case "quit":
					keepRunning = false;
					break;
					
				default:
					System.out.println("Invalid command! Please try again");
					break;
				}
			}
		}
		
	} // End main
} // End App
