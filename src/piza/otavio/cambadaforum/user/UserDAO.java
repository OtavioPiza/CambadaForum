package piza.otavio.cambadaforum.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import piza.otavio.cambadaforum.DAO;
import piza.otavio.cambadaforum.exceptions.LoginOrPasswordException;
import piza.otavio.cambadaforum.exceptions.UserAlreadyExistsException;
import piza.otavio.cambadaforum.exceptions.UserNotFoundException;

/**
 * Child of the DAO class responsible for the access and manipulation of the users topics on the
 * PostgreSQl's server
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 19th 2020
 */
public class UserDAO extends DAO {
	
	/**
	 * Method responsible for adding points to a user
	 * 
	 * @param login of the user
	 * @param points to be added
	 * @throws Exception if the operation on the database was unsuccessful
	 */
	public static void addPoints(String login, int points) throws UserNotFoundException {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			
			PreparedStatement stm = c.prepareStatement(
					"UPDATE users SET points= points + ? WHERE login = ?;");
			stm.setString(2, login);
			stm.setInt(1, points);
			stm.executeUpdate();
			
		} catch (SQLException e) {
			throw new UserNotFoundException("User not found try to log-in again");
		}
	}
	
	/**
	 * Method responsible for getting a user with a given login
	 * 
	 * @param login of the user 
	 * @return User object with the given login
	 * @throws UserNotFoundException if the operation on the database was unsuccessful
	 */
	public static User getUser(String login) throws UserNotFoundException {

		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement("SELECT * FROM users WHERE login = ?;");
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			User user = new User();
			
			rs.next();
			user.setEmail(rs.getString("email"));
			user.setLogin(rs.getString("login"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setPoints(Integer.parseInt(rs.getString("points")));
				
			return user;
		} catch (SQLException e) {
			throw new UserNotFoundException("User not found");
		}
	}
	
	/**
	 * Method responsible for getting the top ten users with the most points
	 * 
	 * @return a list with the login of the top ten users of the form by points
	 * @throws UserNotFoundException if the operation on the database
	 */
	public static List<String> getUserRanking() throws UserNotFoundException {

		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement(
					"SELECT login, points FROM users ORDER BY points DESC LIMIT 10;");
			ResultSet rs = stm.executeQuery();
			List<String> ranking = new ArrayList<>();
			int position = 1;
			
			while(rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append(Integer.toString(position)).append(" - ");
				sb.append(rs.getString("login")).append(" : ");
				sb.append(Integer.toString(rs.getInt("points"))).append(" points");
				ranking.add(sb.toString());
				position++;
			}
			return ranking;
		} catch (SQLException e) {
			throw new UserNotFoundException(
					"There was an error loading the users! Please try again later");
		}
	}
	
	/**
	 * Method responsible for logging a user in
	 * 
	 * @param login of the user
	 * @param password of the user
	 * @return a user object containing the user's info
	 * @throws LoginOrPasswordException if the operation in the database was unsuccessful such as 
	 * when the login or password is include
	 */
	public static User login(String login, String password) throws LoginOrPasswordException {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement(
					"SELECT * FROM users WHERE login = ? AND password = ?;");
			stm.setString(1, login);
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setPoints(Integer.parseInt(rs.getString("points")));
				return user;
			} else {
				throw new LoginOrPasswordException ("Login/Password incorrect");
			}
		} catch (SQLException e) {
			throw new LoginOrPasswordException ("Login/Password incorrect");
		}
	}
	
	/**
	 * Method responsible for registering a new user to the database
	 * 
	 * @param user object with all information contained in it
	 * @throws UserAlreadyExistsException if the operation on the database was unsuccessful such as
	 * when the login is already registered
	 */
	public static void register(User user) throws UserAlreadyExistsException {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			String sql = "INSERT INTO users(email, login, name, password, points) "
					+ "VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, user.getEmail());
			stm.setString(2, user.getLogin());
			stm.setString(3, user.getName());
			stm.setString(4, user.getPassword());
			stm.setInt(5, user.getPoints());
			stm.executeUpdate();
			
		} catch (SQLException e) {
			throw new UserAlreadyExistsException("This login is already registered!");
		}
	}
	
	/**
	 * Method that resets all users in the database
	 */
	public static void resetUsers() {
		
		try(Connection c = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stm = c.prepareStatement("DELETE FROM public.users;");
			stm.executeUpdate();
	
		} catch (SQLException e) {
			System.out.println("Unable to reset users: " + e.getMessage());
		}
	}
}