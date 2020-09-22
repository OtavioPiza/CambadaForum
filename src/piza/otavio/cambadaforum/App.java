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
	public static void main(String[] args) {
		AppCommands[] commands = AppCommands.values();
		boolean keepRunning = true;
		
		System.out.println("Welcome to the CambadaForum configuration tool!");
		System.out.println("Here are the commands available to you:\n");
		
		for (AppCommands command : commands) {
			System.out.printf("%-10s | %s%n", command.getCommand(), command.getDescription());
		}
		System.out.println();

		try (Scanner sc = new Scanner(System.in)) {
			
			while(keepRunning) {
				String command = sc.nextLine();
				
				switch(command) {
				
				case "config":
					System.out.printf(
							"The current cofiguration is:%nURL      | %s%nUser     |"
							+ " %s%nPassword | %s%n", 
							DAO.sqlUrl, DAO.sqlUser, "*****");
					System.out.println("\nAre you sure you want to change it? (y/n)");
					
					if (sc.nextLine().contentEquals("y")) {
						System.out.println("\nplease enter the URL to a postgres database: ");
						DAO.sqlUrl = sc.nextLine();
						System.out.println("please the user of that datase: ");
						DAO.sqlUser = sc.nextLine();
						System.out.println("please the password of that datase: ");
						DAO.sqlPassword = sc.nextLine();
						System.out.println("The database is set up!\n");
					}
					break;
				
				case "help":
					System.out.println("Here are the commands available to you:\n");
					
					for (AppCommands i : commands) {
						System.out.printf("%-10s | %s%n",
								i.getCommand(), i.getDescription());
					}
					System.out.println();
					break;
					
				case "reset":
					System.out.println("This will wipe the database clean! "
							+ "Are you sure you want to proceed? (y/n)");
					
					if (sc.nextLine().contentEquals("y")) {
						System.out.print("Type the database's user's password to proceed: ");
						
						if (sc.nextLine().contentEquals(DAO.sqlPassword)) {
							DAO.setUp();
							System.out.println("Done!\n");
						} else {
							System.out.println("You entered and invalid password");
						} // End if
					} // End if
					
					break;
				
				case "quit":
					keepRunning = false;
					break;
					
				default:
					System.out.printf("No such command: %s! Please try again%n", command);
					break;
				} // End switch
			} // End while
			System.out.println("Program ended");
		} // End try-with resources
	} // End main
} // End App
