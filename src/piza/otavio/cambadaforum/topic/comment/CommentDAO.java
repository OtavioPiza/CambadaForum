package piza.otavio.cambadaforum.topic.comment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import piza.otavio.cambadaforum.DAO;
import piza.otavio.cambadaforum.exceptions.UnableToGetCommentException;
import piza.otavio.cambadaforum.exceptions.UnableToWriteCommentException;
import piza.otavio.cambadaforum.exceptions.UserNotFoundException;
import piza.otavio.cambadaforum.user.UserDAO;

/**
 * Child of the DAO class responsible for the access and manipulation of the comments table on the
 * PostgreSQL's server
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 19th 2020
 */
public class CommentDAO extends DAO {
	
	/**
	 * Method responsible for creating a comment 
	 * 
	 * @param Comment object
	 * @throws UserNotFoundException 
	 * @throws Exception if the operation on the database was unsuccessful
	 */
	public static void createComment(Comment comment) throws UnableToWriteCommentException,
			UserNotFoundException {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement(
			"INSERT INTO public.comments(comment, login, topic_id)"
			+ " VALUES (?, ?, ?);");
			
			stm.setString(1, comment.getContent());
			stm.setString(2, comment.getLogin());
			stm.setInt(3, comment.getTopicId());
			stm.executeUpdate();
			
			UserDAO.addPoints(comment.getLogin(), 10);
			
		} catch (SQLException e) {
			throw new UnableToWriteCommentException("Unable to write comment");
		}
	}
	
	/**
	 * Method responsible for obtaining a list containing all comments of a given topic
	 * 
	 * @param topicId
	 * @return a list of Comment objects 
	 * @throws Exception id the operation on the database was unsuccessful
	 */
	public static List<Comment> getComments(String topicId) throws UnableToGetCommentException {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement(
					"SELECT * FROM public.comments WHERE topic_id = ?;");
			stm.setInt(1, Integer.parseInt(topicId));
			ResultSet rs = stm.executeQuery();
			List<Comment> comments = new ArrayList<>();
			
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setContent(rs.getString("comment"));
				comment.setLogin(rs.getString("login"));
				comments.add(comment);
			}
			return comments;
			
		} catch (SQLException e) {
			throw new UnableToGetCommentException("Unable to get topic's comments!");
		}
	}
	
	/**
	 * Method that resets all the comments on the database
	 */
	public static void resetComments() {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement("DELETE FROM public.comments;");
			stm.executeUpdate();
	
		} catch (SQLException e) {
			System.out.println("Unable to reset comments: " + e.getMessage());
		}
	}
}
