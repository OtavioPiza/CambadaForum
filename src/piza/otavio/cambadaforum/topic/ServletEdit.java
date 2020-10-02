package piza.otavio.cambadaforum.topic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import piza.otavio.cambadaforum.DAOLogger;

/**
 * Servlet responsible for editing the topic in the database
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 13th 
 */
@WebServlet("/edit_topic")
public class ServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID

	/**
	 * Post method that edits the topic content in the database
	 * 
	 * @throws IO & ServletException if the operation couldn't be completed
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Topic topic = new Topic();    // Stores the topic's altered content
		String topicId = (String) request.getSession().getAttribute("edit_topic_id"); // Topic id
		
		topic.setId(Integer.parseInt(topicId));
		topic.setContent(request.getParameter("content"));
		
		try {
			TopicDAO.editTopic(topic);
			DAOLogger.log(8, (String) request.getSession().getAttribute("login"));
			
		} catch (Exception e) {
			DAOLogger.log(9, (String) request.getSession().getAttribute("login"));
		
		}
		response.sendRedirect("view_topic?topic_id=" + topicId);
	}
}