package piza.otavio.cambadaforum.navigation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet responsible for showing the about section of the web forum
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 10th 2020
 */
@WebServlet("/about")
public class ServletAbout extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID

	/**
	 * Get method that displays the about.jsp page to the user
	 * 
	 * @throws IO & ServletExceptions if the page is not found
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/about.jsp").forward(request, response);
	}
}