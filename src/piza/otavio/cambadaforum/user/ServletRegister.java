package piza.otavio.cambadaforum.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

import piza.otavio.cambadaforum.DAOLogger;

/**
 * Servlet responsible for registering a new user
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-19
 */
@WebServlet("/RegisterUser")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID

	/**
	 * Post method that registers a new user
	 * 
	 * @throws IO & ServletException if the operation is unsuccessful
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(); // Stores the user object to be registered

		try {

			if (!request.getParameter("email").contains("@")) {
				throw new Exception("Please enter a valid email");
			}
			user.setEmail(request.getParameter("email"));
			user.setLogin(request.getParameter("login"));
			user.setName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
			UserDAO.register(user);
			DAOLogger.log(0, request.getParameter("login"));
			response.sendRedirect("login?status=You have successfully registered!" 
					+ " Now you can make your login.");

		} catch (Exception e) {
			DAOLogger.log(1, request.getParameter("login"));
			response.sendRedirect("register?status=" + e.getMessage());
		} // try-catch block
	} // doPost(...)
} // ServletRegister
