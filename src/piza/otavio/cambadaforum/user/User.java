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
	} // getEmail()
	
	/**
	 * Gets the login of the user
	 * 
	 * @return the login of the user
	 */
	public String getLogin() {
		return login;
	} // getLogin()
	
	/**
	 * Gets the name of the user
	 * 
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	} // getName()
	
	/**
	 * Gets the user password
	 * 
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	} // getPassword()
	
	/**
	 * Gets the points of the user
	 * 
	 * @return the points of the user
	 */
	public int getPoints() {
		return points;
	} // getPoints()
	
	/**
	 * Sets the email of the user
	 * 
	 * @param email of the user
	 */
	public void setEmail(String email) {
		this.email = email;
	} // setEmail(...)
	
	/**
	 * Sets the login of the user
	 * 
	 * @param login of the user
	 */
	public void setLogin(String login) {
		this.login = login;
	} // setLogin(...)
	
	/**
	 * Sets the name of the user
	 * 
	 * @param name of the user
	 */
	public void setName(String name) {
		this.name = name;
	} // setName(...)
	
	/**
	 * Sets the password of the user
	 * 
	 * @param password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	} // setPassword(...)
	
	/**
	 * Sets the points of the user
	 * 
	 * @param points of the user
	 */
	public void setPoints(int points) {
		this.points = points;
	} // setPoints(...)
	
	
	// Methods
	/**
	 * Adds points to the user
	 * 
	 * @param points to be added
	 */
	public void addPoints(int points) {
		this.points += points;
	} // addPoints(...)
} // User