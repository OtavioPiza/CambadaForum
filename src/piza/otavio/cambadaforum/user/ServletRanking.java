package piza.otavio.cambadaforum.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import piza.otavio.cambadaforum.DAOLogger;
import piza.otavio.cambadaforum.exceptions.UserNotFoundException;

/**
 * Servlet responsible for getting the top ten users by points
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-19
 */
@WebServlet("/ranking")
public class ServletRanking extends HttpServlet {
	private static final long serialVersionUID = 1L;	// Version UID

	/**
	 * Get method that gets the top ten users by points
	 * 
	 * @throws IO & ServletException if the operation is unsuccessful
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<String> ranking;	// Stores the top ten users by points
		
		try {
			ranking = UserDAO.getUserRanking();
			request.setAttribute("ranking", ranking);
			
		} catch (UserNotFoundException e) {
			DAOLogger.log(13, (String) request.getSession().getAttribute("login"));
			request.setAttribute("rankingError", e.getMessage());
			
		} finally {
			request.getRequestDispatcher("ranking.jsp").forward(request, response);
		}
	}
}
