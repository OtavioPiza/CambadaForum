package piza.otavio.cambadaforum.navigation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import piza.otavio.cambadaforum.topic.Topic;
import piza.otavio.cambadaforum.topic.TopicDAO;

/**
 * Servlet responsible for showing the edit topic page to the user
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 10th 2020
 */
@WebServlet("/edit")
public class ServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID
    
	/**
	 * Get method that displays the edit_topic.jsp page to the user if they are the owner of that 
	 * topic in particular, if they are not, they are redirected to their main page and are told why
	 * that happened
	 * 
	 * @throws IO & ServletExceptions if the file edit_topics.jsp is not found 
	 * @throws Exception if the user is not the owner of the topic they are trying to edit
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String status = null;         // Stores the status of the topic to be displayed to the user
		
		try {
			// Stores the topic id
			Topic topic = TopicDAO.getTopic(Integer.parseInt(request.getParameter("topic_id"))); 
			List<String> topicString = new ArrayList<>(); // Strings of the topic content
			
			topicString.add(topic.getTitle());
			topicString.add(topic.getContent());
			topicString.add(topic.getLogin());
			topicString.add(Integer.toString(topic.getId()));
			request.getSession().setAttribute("edit_topic_id", request.getParameter("topic_id"));
			request.setAttribute("topic", topicString);
			request.setAttribute("owner", 
					topic.isOwner((String) request.getSession().getAttribute("login")));
			
		} catch (Exception e) {
			status = "Unable to find the topic you were looking for!";
			response.sendRedirect("main?status=" + status);
		
		} finally {
			request.getRequestDispatcher("edit_topic.jsp").forward(request, response);
		}// End try-catch block
	} // End doGet()
} // End ServletEdit
