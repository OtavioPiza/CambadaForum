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
	} // End getEmail()
	
	/**
	 * Gets the login of the user
	 * 
	 * @return the login of the user
	 */
	public String getLogin() {
		return login;
	} // End getLogin()
	
	/**
	 * Gets the name of the user
	 * 
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	} // End getName()
	
	/**
	 * Gets the user password
	 * 
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	} // End getPassword()
	
	/**
	 * Gets the points of the user
	 * 
	 * @return the points of the user
	 */
	public int getPoints() {
		return points;
	} // End getPoints()
	
	/**
	 * Sets the email of the user
	 * 
	 * @param email of the user
	 */
	public void setEmail(String email) {
		this.email = email;
	} // End setEmail(...)
	
	/**
	 * Sets the login of the user
	 * 
	 * @param login of the user
	 */
	public void setLogin(String login) {
		this.login = login;
	} // End setLogin(...)
	
	/**
	 * Sets the name of the user
	 * 
	 * @param name of the user
	 */
	public void setName(String name) {
		this.name = name;
	} // End setName(...)
	
	/**
	 * Sets the password of the user
	 * 
	 * @param password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	} // End setPassword(...)
	
	/**
	 * Sets the points of the user
	 * 
	 * @param points of the user
	 */
	public void setPoints(int points) {
		this.points = points;
	} // End setPoints(...)
	
	
	// Methods
	/**
	 * Adds points to the user
	 * 
	 * @param points to be added
	 */
	public void addPoints(int points) {
		this.points += points;
	} // End addPoints(...)
} // End User