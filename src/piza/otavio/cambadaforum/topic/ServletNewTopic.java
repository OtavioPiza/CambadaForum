package piza.otavio.cambadaforum.topic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import piza.otavio.cambadaforum.DAOLogger;

/**
 * Servlet responsible for creating a new topic in the database
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 13th 2020
 */
@WebServlet("/new_topic")
public class ServletNewTopic extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID

	/**
	 * Post method that adds a new topic to the database
	 * 
	 * @throws IO & ServletException if the operation is unsuccessful
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Topic topic = new Topic(); // Stores the topic's content
		
		topic.setContent(request.getParameter("content"));
		topic.setLogin((String) request.getSession().getAttribute("login"));
		topic.setTitle(request.getParameter("title"));
		
		try {
			TopicDAO.createTopic(topic);
			response.sendRedirect("/CambadaForum/main?status=Topic+created+successfully");
			DAOLogger.log(4, (String) request.getSession().getAttribute("login"));
			
		} catch (Exception e) {
			DAOLogger.log(5, (String) request.getSession().getAttribute("login"));
			request.setAttribute("newTopicError", e.getMessage());
			request.getRequestDispatcher("new_topic.jsp").forward(request, response);
		}
	}
}
