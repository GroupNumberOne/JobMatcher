package webapp.java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectorSingleton {
	private String databaseUrl;
	private Properties props;
	private Connection databaseConn;
	private static DBConnectorSingleton uniqueInstance;
	
	// set up connection with database
	private DBConnectorSingleton(String host, String port, String dbname, String user, String pw) throws SQLException {
		databaseUrl = "jdbc:postgresql://"+host+":"+port+"/"+dbname;
		props = new Properties();
		props.setProperty("user",user);
		props.setProperty("password",pw);
			
		databaseConn = DriverManager.getConnection(databaseUrl, props);
		
		if(databaseConn != null) {
			System.out.println("Verbinding gemaakt.");
		}
		else {
			System.out.println("Geen verbinding.");
		}
	}
	
	// return database connection
	public Connection getDBConn() {
		return databaseConn;
	}
	
	public static DBConnectorSingleton getInstance(String host, String port, String dbname, String user, String pw) throws SQLException {
		if (uniqueInstance == null) {
			uniqueInstance = new DBConnectorSingleton(host, port, dbname, user, pw);
			System.out.println("Ik ben aangemaakt!");
		}
		else {
			System.out.println("Ik ben al aangemaakt!");
		}
		return uniqueInstance;
		
	}
}
