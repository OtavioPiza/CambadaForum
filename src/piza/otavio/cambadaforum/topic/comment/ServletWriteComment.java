package piza.otavio.cambadaforum.topic.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import piza.otavio.cambadaforum.DAOLogger;

/**
 * Servlet responsible for creating a new comment in the database
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 19th 2020
 */
@WebServlet("/write_comment")
public class ServletWriteComment extends HttpServlet {
	private static final long serialVersionUID = 1L; // Version UID
       
	/**
	 * Post method that adds a new comment to a topic in the database
	 * 
	 * @throws IO & ServletException if the operation is unsuccessful
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String status = "&status=";       // Records the status of the operation
		Comment comment = new Comment();  // Stores the comment and its author
		
		comment.setLogin((String) request.getSession().getAttribute("login"));
		comment.setContent(request.getParameter("comment_content"));
		comment.setTopicId(Integer.parseInt(request.getParameter("topic_id")));
		
		try {
			CommentDAO.createComment(comment);
			status = "&status=Comment+added+successfully";
			DAOLogger.log(6, (String) request.getSession().getAttribute("login"));
			
		} catch (Exception e) {
			request.setAttribute("commentsError", e.getMessage());
			DAOLogger.log(7, (String) request.getSession().getAttribute("login"));
			
		} finally {
			response.sendRedirect("/CambadaForum/view_topic?topic_id="
					+ request.getParameter("topic_id") + status);
		} // try-catch block
	} // doPost(...)
} // ServletWriteComment