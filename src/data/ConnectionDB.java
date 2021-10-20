package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	public static Connection getConnection() throws SQLException {

		String user, pwd, service, url = null;
		Connection currentConnection = null;

		user = "bank";
		pwd = "bank";
		service = "localhost";
		url = "jdbc:oracle:thin:";
		url += user + "/" + pwd + "@" + service;

		currentConnection = DriverManager.getConnection(url);

		return currentConnection;

	}

}
