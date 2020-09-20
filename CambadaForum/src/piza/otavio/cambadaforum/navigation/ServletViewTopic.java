package piza.otavio.cambadaforum.navigation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import piza.otavio.cambadaforum.topic.TopicDAO;
import piza.otavio.cambadaforum.topic.comment.CommentDAO;
import piza.otavio.cambadaforum.user.User;
import piza.otavio.cambadaforum.user.UserDAO;

/**
 * Servlet responsible for showing a specified topic's page to the user
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 13th 2020
 */
@WebServlet("/view_topic")
public class ServletViewTopic extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID
       
	/**
	 * Get method that displays the view_topic.jsp file to the user, in which one can view the topic
	 * itself, the topic's comments, and a text box where one can post new comments
	 * 
	 * @throws IO & ServletExceptions if the file view_topic.jsp is not found
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		/**
		 * Section responsible for getting the user's data
		 */
		try {
			// Stores the user info obtained in the database
			User user = UserDAO.getUser((String) request.getSession().getAttribute("login")); 
			request.getSession().setAttribute("points", user.getPoints());
			
		} catch (Exception e1) {
			e1.printStackTrace();
		} // End try-catch block
		
		/**
		 * Section responsible for getting the topic's content
		 */
		String[] topic = null; // Stores the topic information in a String[]
		
		try {
			topic = TopicDAO.getTopic(Integer.parseInt(request.getParameter("topic_id")))
					.getString();
			request.setAttribute("topic", topic);
			request.setAttribute("owner",((String) request.getSession().getAttribute("login"))
					.contentEquals(topic[2]));
			
		} catch (Exception e) {
			request.setAttribute("topicError", e.getMessage());
		} // End try-catch block
		
		
		/**
		 * Section responsible for getting the topic's comments
		 */
		// CommentDAO object used to access the info in the database
		List<String[]> comments = new ArrayList<>(); // Stores the topic's comment on a string array
		
		try {
			CommentDAO.getComments(request.getParameter("topic_id")).forEach(
					comment -> comments.add(comment.getString()));
			request.setAttribute("comments", comments);
			
		} catch (Exception e) {
			request.setAttribute("commentsError", e.getMessage());
			
		} finally {
			request.getRequestDispatcher("view_topic.jsp").forward(request, response);
		} // End try-catch block
	} // End doGet()
} // End ServletViewTopic