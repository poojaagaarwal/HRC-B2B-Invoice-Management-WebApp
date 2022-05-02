package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/grey_goose";
	static final String username = "root";
	static final String password = "password";
	public Connection getConnection() throws Exception{
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(url,username,password);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}