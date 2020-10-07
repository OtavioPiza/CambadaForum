package piza.otavio.cambadaforum.topic;

/**
 * Class that represents the forum's topics
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 13th 2020
 */
public class Topic {
	private String title;	// Title of the topic
	private String content;	// Body of the topic
	private String login;	// Login of the author of the topic
	private int id;			// ID of the topic (created by the SQL server)
	
	// Getters & Setters //
	/**
	 * Gets the topic's title
	 * 
	 * @return topic's title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Gets the topic's content
	 * 
	 * @return topic's content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Gets the topic's id
	 * 
	 * @return topic's id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the topic's author's login
	 * 
	 * @return topic's author login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Gets the topic's information and puts it into a String[]
	 * 
	 * @return a String[] with the topic's information
	 */
	public String[] getString() {
		return new String[] {title, content, login, Integer.toString(id)};
	}
	
	/**
	 * Sets the topic's title
	 * 
	 * @param topic's title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Sets the topic's content
	 * 
	 * @param topic's content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Sets the topic's id
	 * 
	 * @param topic's id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Sets the topic's author's login
	 * 
	 * @param topic's author's login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	// Methods //
	/**
	 * Verifies if someone is the owner a given topic
	 * 
	 * @param login
	 * @return if the login passed is that of the topic's author
	 */
	public boolean isOwner(String login) {
		return login.contentEquals(this.login);
	}
}
