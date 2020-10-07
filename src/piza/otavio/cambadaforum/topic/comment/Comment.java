package piza.otavio.cambadaforum.topic.comment;

/**
 * Class that represents the comments of the forum's topic
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 19th 2020
 */
public class Comment {
	private String content;	// Comment's content
	private String login;	// Comment's author's login
	private int topicId;	// Comment's topic id provided by the PostgreSQL database
	
	// Getters and Setters
	/**
	 * Gets the comment's content
	 * 
	 * @return the comment's content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Gets the comment's author's login
	 * 
	 * @return the comment's author's login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Gets the comment's topic id
	 * 
	 * @return the comment's topic id
	 */
	public int getTopicId() {
		return topicId;
	}
	
	/**
	 * Gets the comment's information and returns it in a String[]
	 * 
	 * @return String[] containing the comment's information
	 */
	public String[] getString() {
		return new String[] {content, login};
	}
	
	/**
	 * Sets the comment's content
	 * 
	 * @param comment's content 
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Sets the comment's author's login
	 * 
	 * @param comment's author's login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Sets the comment's topic id
	 * 
	 * @param topicId()
	 */
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
}
