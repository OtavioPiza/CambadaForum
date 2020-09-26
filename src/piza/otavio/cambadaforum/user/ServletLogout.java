package piza.otavio.cambadaforum.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet responsible for logging an user out
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-19
 */
@WebServlet("/logout")
public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID
	
	/**
	 * Get method responsible for logging an user out
	 * 
	 * @throws IO & ServletException if the operation is unsuccessful
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getSession().setAttribute("email", "");
		request.getSession().setAttribute("login", "");
		request.getSession().setAttribute("name", "");
		request.getSession().setAttribute("points", "");
		request.getSession().setAttribute("loged", "false");
		response.sendRedirect("login?status=Log out successful");
	} // doGet()
} // ServletLogout