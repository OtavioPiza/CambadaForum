package piza.otavio.cambadaforum.topic;

/**
 * Class that represents the forum's topics
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 13th 2020
 */
public class Topic {
	private String title;	// Title of the topic
	private String content; // Body of the topic
	private String login;   // Login of the author of the topic
	private int id;			// ID of the topic (created by the SQL server)
	
	// Getters & Setters //
	/**
	 * Gets the topic's title
	 * 
	 * @return topic's title
	 */
	public String getTitle() {
		return title;
	} // getTitle()
	
	/**
	 * Gets the topic's content
	 * 
	 * @return topic's content
	 */
	public String getContent() {
		return content;
	} // getContent()
	
	/**
	 * Gets the topic's id
	 * 
	 * @return topic's id
	 */
	public int getId() {
		return id;
	} // getId()
	
	/**
	 * Gets the topic's author's login
	 * 
	 * @return topic's author login
	 */
	public String getLogin() {
		return login;
	} // getLogin()
	
	/**
	 * Gets the topic's information and puts it into a String[]
	 * 
	 * @return a String[] with the topic's information
	 */
	public String[] getString() {
		return new String[] {title, content, login, Integer.toString(id)};
	} // getString()
	
	/**
	 * Sets the topic's title
	 * 
	 * @param topic's title
	 */
	public void setTitle(String title) {
		this.title = title;
	} // setTitle(...)
	
	/**
	 * Sets the topic's content
	 * 
	 * @param topic's content
	 */
	public void setContent(String content) {
		this.content = content;
	} // setContent(...)
	
	/**
	 * Sets the topic's id
	 * 
	 * @param topic's id
	 */
	public void setId(int id) {
		this.id = id;
	} // setId(...)
	
	/**
	 * Sets the topic's author's login
	 * 
	 * @param topic's author's login
	 */
	public void setLogin(String login) {
		this.login = login;
	} // setLogin(...)
	
	
	// Methods //
	/**
	 * Verifies if someone is the owner a given topic
	 * 
	 * @param login
	 * @return if the login passed is that of the topic's author
	 */
	public boolean isOwner(String login) {
		return login.contentEquals(this.login);
	} // isOwner(...)
} // Topic
