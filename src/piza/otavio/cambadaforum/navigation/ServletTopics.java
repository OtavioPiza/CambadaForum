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

/**
 * Servlet responsible for displaying all topics on the forum's database
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September  13th 2020
 */
@WebServlet("/topics")
public class ServletTopics extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID
       
	/**
	 * Get method that displays all forum's topics
	 * 
	 * @throws IO & ServletException if the operation is unsuccessful
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			List<String[]> topics = new ArrayList<>();
			TopicDAO.getTopics().forEach(topic -> topics.add(topic.getString()));
			request.setAttribute("topics", topics);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("topicsError", e.getMessage());
			
		}finally {
			request.getRequestDispatcher("topics.jsp").forward(request, response);
		} // End try-catch block
	} // End doGet()
} // End ServletTopics
