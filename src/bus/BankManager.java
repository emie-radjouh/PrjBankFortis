package bus;

import java.util.ArrayList;

public class BankManager {
	String bankName;

	private static ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public static ArrayList<Customer> getListOfAccounts() {
		return listOfCustomers;
	}

}
