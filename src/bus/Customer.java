package bus;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import bus.Account;
import data.CustomerDB;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8310101750330602652L;
	private String customerNum;
	private String customerName;
	private String customerPIN;
	private String customerEmail;

	// Getters and setters for all the fields
	public String getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPIN() {
		return customerPIN;
	}

	public void setCustomerPIN(String customerPIN) {
		this.customerPIN = customerPIN;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	// Constructors

	public Customer() {
		this.customerNum = "Undefined";
		this.customerName = "Undefined";
		this.customerPIN = "Undefined";
		this.customerEmail = "Undefined";
	}

	public Customer(String customerNum, String customerName, String customerPIN, String customerEmail) {
		this.customerNum = customerNum;
		this.customerName = customerName;
		this.customerPIN = customerPIN;
		this.customerEmail = customerEmail;

	}

	// ToString
	@Override
	public String toString() {
		return "Customer [Customer number: " + customerNum + ", Full name:" + customerName + ", PIN:" + customerPIN
				+ ", Email:" + customerEmail + "]";
	}

	// public static database operations
	public static int add(Customer aCustomer) throws SQLException {
		return CustomerDB.insert(aCustomer);
	}

	public static int delete(String customerID) throws SQLException {
		return CustomerDB.remove(customerID);
	}

	public static int Update(String ID, String name, String Pin, String Email) throws SQLException {
		return CustomerDB.update(ID, name, Pin, Email);
	}

	public static ResultSet Search(String customerID) throws SQLException {
		return CustomerDB.search(customerID);
	}

}
