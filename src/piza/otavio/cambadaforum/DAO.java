package piza.otavio.cambadaforum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import piza.otavio.cambadaforum.topic.TopicDAO;
import piza.otavio.cambadaforum.topic.comment.CommentDAO;
import piza.otavio.cambadaforum.user.UserDAO;

/**
 * Parent class of all classes that access the postgreSQL's server it contains the server's URL user
 * and password
 * 
 * @author Otavio Sartorelli de Toledo Piza
 * @version September 11th 2020
 */
public class DAO {

	protected static String sqlUser = "postgres"; 				     // postgreSQL's user
	protected static String sqlPassword = "admin"; 				     // postgreSQL's user's password
	protected static String sqlUrl = "jdbc:postgresql:CambadaForum"; // postgreSQL's server URL

	/**
	 * Protected class constructor to hide the implicit public one
	 */
	protected DAO () {
	}
	
	/**
	 * Method that creates the necessary tables on the postgreSQL's server to enable the web forum 
	 * to work as expected
	 */
	public static void createTables () {
		 
		try(Connection c = DriverManager.getConnection (sqlUrl, sqlUser, sqlPassword)) {
			PreparedStatement stmUsers = c.prepareStatement (
					"CREATE TABLE public.users" + 
					"(" + 
					"    email text COLLATE pg_catalog.\"default\"," + 
					"    login text COLLATE pg_catalog.\"default\" NOT NULL," + 
					"    name text COLLATE pg_catalog.\"default\"," + 
					"    password text COLLATE pg_catalog.\"default\"," + 
					"    points integer," + 
					"    CONSTRAINT usuario_pkey PRIMARY KEY (login)" + 
					")" + 
					"TABLESPACE pg_default;" + 
					"ALTER TABLE public.users" + 
					"    OWNER to postgres;"
					);
			
			PreparedStatement stmSeqTopicId = c.prepareStatement (
					"CREATE SEQUENCE topic_id_topic_seq" + 
					"  INCREMENT 1" + 
					"  MINVALUE 1" + 
					"  MAXVALUE 9223372036854775807" + 
					"  START 1" + 
					"  CACHE 1;"
					);
			
			PreparedStatement stmTopic = c.prepareStatement (
					"CREATE TABLE public.topic" + 
					"(" + 
					"    topic_id integer NOT NULL DEFAULT nextval('topic_id_topic_seq'::regclass)," + 
					"    topic_title text COLLATE pg_catalog.\"default\"," + 
					"    topic_content text COLLATE pg_catalog.\"default\"," + 
					"    login text COLLATE pg_catalog.\"default\"," + 
					"    CONSTRAINT topic_pkey PRIMARY KEY (topic_id)," + 
					"    CONSTRAINT topic_login_fkey FOREIGN KEY (login)" + 
					"        REFERENCES public.users (login) MATCH SIMPLE" + 
					"        ON UPDATE NO ACTION" + 
					"        ON DELETE NO ACTION" + 
					")" + 
					"TABLESPACE pg_default;" + 
					"ALTER TABLE public.topic" + 
					"    OWNER to postgres;"
					);
			
			PreparedStatement stmCommentSeq = c.prepareStatement (
					"CREATE SEQUENCE comment_id_comment_seq" + 
					"  INCREMENT 1" + 
					"  MINVALUE 1" + 
					"  MAXVALUE 9223372036854775807" + 
					"  START 1" + 
					"  CACHE 1;"
					);
			
			PreparedStatement stmComments = c.prepareStatement (
					"CREATE TABLE public.comments" + 
					"(" + 
					"    comment_id integer NOT NULL DEFAULT " + 
					"nextval('comment_id_comment_seq'::regclass)," + 
					"    comment text COLLATE pg_catalog.\"default\"," + 
					"    login text COLLATE pg_catalog.\"default\"," + 
					"    topic_id integer," + 
					"    CONSTRAINT comment_pkey PRIMARY KEY (comment_id)," + 
					"    CONSTRAINT comment_id_topic_fkey FOREIGN KEY (topic_id)" + 
					"        REFERENCES public.topic (topic_id) MATCH SIMPLE" + 
					"        ON UPDATE NO ACTION" + 
					"        ON DELETE NO ACTION," + 
					"    CONSTRAINT comment_login_fkey FOREIGN KEY (login)" + 
					"        REFERENCES public.users (login) MATCH SIMPLE" + 
					"        ON UPDATE NO ACTION" + 
					"        ON DELETE NO ACTION" + 
					")" + 
					"TABLESPACE pg_default;" + 
					"ALTER TABLE public.comments" + 
					"    OWNER to postgres;"
					);
			
			stmUsers.execute();
			stmSeqTopicId.execute();
			stmTopic.execute();
			stmCommentSeq.execute();
			stmComments.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} // End try-catch block
	} // End createTables ()
	
	/**
	 * Method responsible for reseting the database to a default state
	 * 
	 * @throws Exception if the database can not be accessed
	 */
	public static void setUp() {
		CommentDAO.resetComments();
		TopicDAO.resetTopics();
		UserDAO.resetUsers();
	} // End setUp()
} // End DAO
