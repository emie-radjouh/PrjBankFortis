package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import bus.Customer;

public class CustomerDB {

	public static int insert(Customer record) throws SQLException {
		int success = -1;

		Connection currentConnection = null;
		Statement currentStatement = null;
		String request;

		currentConnection = ConnectionDB.getConnection();

		currentStatement = currentConnection.createStatement();

		request = "insert into customers  values (' " + record.getCustomerNum() + "', '" + record.getCustomerName()
				+ "' , '" + record.getCustomerPIN() + "' , '" + record.getCustomerEmail() + "')";

		success = currentStatement.executeUpdate(request);

		return success;

	}

	public static ResultSet display() throws SQLException {

		Connection currentConnection = null;
		String request;

		currentConnection = ConnectionDB.getConnection();

		request = "SELECT * FROM customers";

		PreparedStatement pst = currentConnection.prepareStatement(request);

		ResultSet rs = pst.executeQuery();

		return rs;

	}

	public static int remove(String id) throws SQLException {
		int success = -1;

		Connection currentConnection = null;
		Statement currentStatement = null;
		String request;

		currentConnection = ConnectionDB.getConnection();

		currentStatement = currentConnection.createStatement();

		request = "delete from customers where NUM =" + id;

		success = currentStatement.executeUpdate(request);

		return success;

	}

	public static int update(String id, String Name, String Pin, String Mail) throws SQLException {
		int success = -1;

		Connection currentConnection = null;
		Statement currentStatement = null;
		String request;

		currentConnection = ConnectionDB.getConnection();

		currentStatement = currentConnection.createStatement();

		request = "UPDATE customers SET NAME ='" + Name + "', PIN='" + Pin + "', EMAIL='" + Mail + "' WHERE NUM =" + id;

		success = currentStatement.executeUpdate(request);

		return success;

	}

	public static ResultSet search(String id) throws SQLException {

		Connection currentConnection = null;
		String request;

		currentConnection = ConnectionDB.getConnection();

		request = "select * from customers where NUM =" + id;

		PreparedStatement pst = currentConnection.prepareStatement(request);

		ResultSet rs = pst.executeQuery();

		return rs;

	}
}
