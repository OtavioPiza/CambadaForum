package piza.otavio.cambadaforum.navigation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import piza.otavio.cambadaforum.DAOLogger;
import piza.otavio.cambadaforum.topic.TopicDAO;
import piza.otavio.cambadaforum.user.User;
import piza.otavio.cambadaforum.user.UserDAO;

/**
 * Servlet responsible for displaying the main page of a user
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 13th 2020
 */
@WebServlet("/main")
public class ServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID

	/**
	 * Get method that displays the main page of a user
	 * 
	 * @throws IO & ServletExcpetion if the file main.jsp is not found
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		User user = null; // Stores the user's information
		
		try {
			user = UserDAO.getUser((String) request.getSession().getAttribute("login"));
			request.getSession().setAttribute("points", user.getPoints());
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			List<String[]> userTopics = new ArrayList<>();
			TopicDAO.getUserTopics((String) request.getSession().getAttribute("login"))
					.forEach(topic -> userTopics.add(topic.getString()));
			request.setAttribute("userTopics", userTopics);
			
		} catch (Exception e) {
			DAOLogger.log(11, (String) request.getSession().getAttribute("login"));
			request.setAttribute("userTopicsError", e.getMessage());
			
		}finally {
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}
}
