package client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import bus.Customer;
import data.ConnectionDB;

public class DBConsoleAppBank {

	public static void main(String[] args) throws SQLException {

		Scanner keyboard = new Scanner(System.in);

		Connection currentConnection = null;
		String message;

		System.out.println(" Connect to Demo databse.");

		currentConnection = ConnectionDB.getConnection();

		if (currentConnection != null) {
			System.out.println("\n connected successfully");
		} else {
			System.out.println("\n not connected ");
		}

		System.out.println(" Insert a new customer into demo database");
		// keyboard.nextLine(); // cin.ignore()
		String num, name, pin, email;

		System.out.print("num ? : ");
		num = keyboard.nextLine();

		System.out.print("name ? : ");
		name = keyboard.nextLine();

		System.out.print("Pin ? : ");
		pin = keyboard.nextLine();

		System.out.print("Email ? : ");
		email = keyboard.nextLine();

		Customer aCustomer = new Customer(num, name, pin, email);

		if (Customer.add(aCustomer) > 0) {
			message = " new customer added with success";
		} else {
			message = " new customer NOT added with success";
		}

		System.out.println(message);

		keyboard.close();

	}

}
