package piza.otavio.cambadaforum.topic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import piza.otavio.cambadaforum.DAO;
import piza.otavio.cambadaforum.exceptions.UnableToCreateTopicException;
import piza.otavio.cambadaforum.exceptions.UnableToEditTopicException;
import piza.otavio.cambadaforum.exceptions.UnableToGetTopicException;
import piza.otavio.cambadaforum.exceptions.UserNotFoundException;
import piza.otavio.cambadaforum.user.UserDAO;

/**
 * Child  of the DAO class responsible for the access and manipulation of the users
 * table on the postgreSQL's server
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 13th 2020
 */
public class TopicDAO extends DAO {

	/**
	 * Method responsible for creating a topic in the database
	 * 
	 * @param Topic object
	 * @throws UserNotFoundException
	 * @throws Exception if the operation on the database was unsuccessful
	 */
	public static void createTopic(Topic topic) throws UnableToCreateTopicException,
			UserNotFoundException {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement(
					"INSERT INTO topic (topic_title, topic_content, login) VALUES (?, ?, ?);");
			
			stm.setString(1, topic.getTitle());
			stm.setString(2, topic.getContent());
			stm.setString(3, topic.getLogin());
			stm.executeUpdate();
			
			UserDAO.addPoints(topic.getLogin(), 30);
			
		} catch (SQLException e) {
			throw new UnableToCreateTopicException("Unable to create new topic!");
		}
	}

	/**
	 * Method responsible for updating the edits to a topic in the database
	 * 
	 * @param Topic object
	 * @throws Exception if the operation on the database was unsuccessful 
	 */
	public static void editTopic(Topic topic) throws UnableToEditTopicException {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement(
					"UPDATE topic SET topic_content = ? WHERE topic_id = ?;");
			stm.setString(1, topic.getContent());
			stm.setInt(2, topic.getId());
			stm.executeUpdate();
			
		} catch (SQLException e) {
			throw new UnableToEditTopicException("Unable to edit topic!");
		}
	}
	
	/**
	 * Method responsible for getting a topic's content 
	 * 
	 * @param id of the topic
	 * @return the topic's content in a Topic object
	 * @throws Exception if the operation on the database was unsuccessful 
	 */
	public static Topic getTopic(int id) throws UnableToGetTopicException {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement(
					"SELECT * FROM topic WHERE topic_id = ?;");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			Topic topic = new Topic();
			
			rs.next();
			topic.setTitle(rs.getString("topic_title"));
			topic.setContent(rs.getString("topic_content"));
			topic.setLogin(rs.getString("login"));
			topic.setId(Integer.parseInt(rs.getString("topic_id")));

			return topic;
			
		} catch (SQLException e) {
			throw new UnableToGetTopicException("Unable to get topic!");
		}
	}
	
	/**
	 * Method responsible for obtaining all topics in the database
	 * 
	 * @return a string[] ArrayList that contains all topics registered in the database
	 * @throws Exception if TopicDAO was unable to obtain the list of topic objects from the
	 * database
	 */
	public static List<Topic> getTopics() throws UnableToGetTopicException {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement(
					"SELECT * FROM topic ORDER BY topic_id DESC;");
			ResultSet rs = stm.executeQuery();
			List<Topic> topics = new ArrayList<>();
			
			while(rs.next()) {
				Topic topic = new Topic();
				topic.setTitle(rs.getString("topic_title"));
				topic.setContent(rs.getString("topic_content"));
				topic.setLogin(rs.getString("login"));
				topic.setId(Integer.parseInt(rs.getString("topic_id")));
				topics.add(topic);
			}
			return topics;
			
		} catch (SQLException e) {
			throw new UnableToGetTopicException("Unable to get forum's topics!");
		}
	}
	
	/**
	 * Method responsible for obtaining all the topics of a given user
	 * 
	 * @param login of the author of the topics
	 * @return a list of all topics of a given users
	 * @throws Exception if the operation on the database was unsuccessful 
	 */
	public static List<Topic> getUserTopics(String login) throws UnableToGetTopicException {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement(
					"SELECT * FROM topic WHERE login = ? ORDER BY topic_id DESC;");
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			List<Topic> userTopics = new ArrayList<>();
			
			while(rs.next()) {
				Topic topic = new Topic();
				topic.setTitle(rs.getString("topic_title"));
				topic.setContent(rs.getString("topic_content"));
				topic.setLogin(rs.getString("login"));
				topic.setId(Integer.parseInt(rs.getString("topic_id")));
				userTopics.add(topic);
			}
			return userTopics;
			
		} catch (SQLException e) {
			throw new UnableToGetTopicException("Unable to get user's topics!");
		}
	}
	
	/**
	 * Method responsible for deleting all topics in the database
	 */
	public static void resetTopics() {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement("DELETE FROM public.topic;");
			stm.executeUpdate();
	
		} catch (SQLException e) {
			System.out.println("Unable to reset topics: " + e.getMessage());
		}
	}
}