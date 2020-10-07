package piza.otavio.cambadaforum.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

import piza.otavio.cambadaforum.DAOLogger;
import piza.otavio.cambadaforum.exceptions.LoginOrPasswordException;

/**
 * Servlet responsible for doing the login of an user
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version 2020-09-19
 */
@WebServlet("/do_login")
public class ServletDoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;	// User UID

	/**
	 * Post method responsible for doing the login of an user
	 * 
	 * @throws IO & ServletException if the operation is unsuccessful
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			UserDAO.login(request.getParameter("password"), request.getParameter("password"));
			User user = UserDAO.login(request.getParameter("login"), 
					request.getParameter("password"));
			
			request.getSession().setAttribute("email", user.getEmail());
			request.getSession().setAttribute("login", user.getLogin());
			request.getSession().setAttribute("name", user.getName());
			request.getSession().setAttribute("points", user.getPoints());
			request.getSession().setAttribute("loged", "true");
			DAOLogger.log(2, request.getParameter("login"));
			response.sendRedirect("main");
			
		} catch (LoginOrPasswordException e) {
			DAOLogger.log(3, request.getParameter("login"));
			response.sendRedirect("login?status=" + e.getMessage());
		}
	}
}