package piza.otavio.cambadaforum.navigation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet responsible for showing the login page to the user
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 13th 2020
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID
       
	/**
	 * Get method that displays the login.jsp page to the user
	 * 
	 * @throws IO & ServletException if the file login.jsp is not found
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("status", request.getParameter("status"));
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} // End doGet()
} // End ServletLogin
