package piza.otavio.cambadaforum.user;

public class User {
	private String email;     // User's email
	private String login;     // User's login
	private String name;      // User's name
	private String password;  // User's password
	private int points = 0;   // User's point
	
	// Getters and Setters
	/**
	 * Gets the email of the user
	 * 
	 * @return the email of the user
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Gets the login of the user
	 * 
	 * @return the login of the user
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Gets the name of the user
	 * 
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the user password
	 * 
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Gets the points of the user
	 * 
	 * @return the points of the user
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Sets the email of the user
	 * 
	 * @param email of the user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Sets the login of the user
	 * 
	 * @param login of the user
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Sets the name of the user
	 * 
	 * @param name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the password of the user
	 * 
	 * @param password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Sets the points of the user
	 * 
	 * @param points of the user
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	// Methods
	/**
	 * Adds points to the user
	 * 
	 * @param points to be added
	 */
	public void addPoints(int points) {
		this.points += points;
	}
}