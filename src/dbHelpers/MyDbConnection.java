/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author danielsaul
 *
 */
public class MyDbConnection {
	
	private static final String dbName = "scif_library";
	private static final String dbUser = "root";
	private static final String dbPwd  = "rootroot";
	
	private static Connection connection = null;
	private MyDbConnection () {}
	
	@SuppressWarnings("deprecation")
	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		
		String url = "jdbc:mysql://scifi-library.cituc08uw3ka.us-east-1.rds.amazonaws.com:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, dbUser, dbPwd); 
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// NOTE: Errors that occur here will show in the Console, but will not
			// stop the web app from running. These errors could be handled better.
			e.printStackTrace();
		}
		
		if (connection == null) {
			throw new RuntimeException("Error connecting to database.");
		}
		
		return connection;
	}	
}