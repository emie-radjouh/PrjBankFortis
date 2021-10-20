package data;

import bus.Account;
import java.io.IOException;
import java.util.ArrayList;
import bus.Customer;

public class DataCollection {

	// private static data
	private static ArrayList<Account> filelistOfAccount = new ArrayList<Account>();

	// public static operations
	// Add an account
	public static void addAccount(Account object) throws IOException, ClassNotFoundException {
		filelistOfAccount.add(object);
		FileHandeler.writeToFileAccount(filelistOfAccount);
	}

	// Remove an account

	public static void removeAccount(String key) throws ClassNotFoundException, IOException {

		Account accountForRemove = new Account();
		try {

			for (Account element : filelistOfAccount) {

				if (((Account) element).getAccountNum().equals(key)) {
					accountForRemove = element;
					filelistOfAccount.remove(accountForRemove);
					System.out.println("Account with the Number of " + key + " removed!");

				}

			}

			FileHandeler.writeToFileAccount(filelistOfAccount);
		} catch (IOException e) {
			System.out.println("File not found! :(\n\n");

		}
		FileHandeler.writeToFileAccount(filelistOfAccount);

	}

	// dsiplay all accounts
	public static void allAccounts() throws ClassNotFoundException {
		try {
			filelistOfAccount = FileHandeler.readFromFileAccount();

			for (Account element : filelistOfAccount) {
				System.out.println(element);
			}

		} catch (IOException e) {
			System.out.println("File not found! :(\n\n");
		}

	}

	// search for an Account by number
	public static Account searchAccount(String key) throws ClassNotFoundException {
		try {
			filelistOfAccount = FileHandeler.readFromFileAccount();

			for (Account element : filelistOfAccount) {

				if (((Account) element).getAccountNum().equals(key)) {
					return element;
				}
			}

			return null;
		} catch (IOException e) {
			System.out.println("File not found! :(");
			return null;
		}
	}

	public static ArrayList<Account> getAccountList() {

		return filelistOfAccount;

	}

	// search for an Account and deposit money
	public static void depositAccount(String key, double amount) throws IOException, ClassNotFoundException {
		filelistOfAccount = FileHandeler.readFromFileAccount();

		for (Account element : filelistOfAccount) {

			if (((Account) element).getAccountNum().equals(key)) {

				element.deposit(amount);
				FileHandeler.writeToFileAccount(filelistOfAccount);
			}
		}

	}

	// search for an Account and withdraw money
	public static void withdrawAccount(String key, double amount) throws IOException, ClassNotFoundException {
		filelistOfAccount = FileHandeler.readFromFileAccount();

		for (Account element : filelistOfAccount) {

			if (((Account) element).getAccountNum().equals(key)) {
				if (amount >= element.getAccountBalance()) {

					System.out.println("Not enought money !");
					;
				} else {
					element.withdrawl(amount);
					FileHandeler.writeToFileAccount(filelistOfAccount);
					System.out.println(amount + "$ was withdrawn.");
				}

			}
		}

	}

	// search for an Account and show details
	public static Account searchAccountInfo(String key) throws IOException, ClassNotFoundException {
		filelistOfAccount = FileHandeler.readFromFileAccount();

		for (Account element : filelistOfAccount) {

			if (((Account) element).getAccountNum().equals(key)) {

				System.out.println(element);
			}
		}
		return null;
	}

	//////////////////////////////////////////////////// customer
	//////////////////////////////////////////////////// ////////////////////////////////////////////
	private static ArrayList<Customer> filelistOfCustomer = new ArrayList<Customer>();

	// public static operations
	// Add an Customer
	public static void addCustomer(Customer object) throws IOException, ClassNotFoundException {
		filelistOfCustomer.add(object);
		FileHandeler.writeToFileCustomer(filelistOfCustomer);
	}

	// Remove a customer
	public static void removeCustomer(String key) throws ClassNotFoundException {
		try {
			filelistOfCustomer = FileHandeler.readFromFileCustomer();

			for (Customer element : filelistOfCustomer) {

				if (((Customer) element).getCustomerNum().equals(key)) {

					// remove customer.
					filelistOfCustomer.remove(element);
					System.out.println("Customer Number " + key + " removed!");
				}
			}
			// save to file
			FileHandeler.writeToFileCustomer(filelistOfCustomer);
		} catch (IOException e) {
			System.out.println("File not found! :(\n\n");
		}
	}

	// dsiplay all customers
	public static void allCustomers() throws ClassNotFoundException {
		try {
			filelistOfCustomer = FileHandeler.readFromFileCustomer();
			for (Customer element : filelistOfCustomer) {
				System.out.println(element);

			}
		} catch (IOException e) {
			System.out.println("File not found! :(\n\n");
		}

	}

	// search for an Customer by number
	public static Customer searchCustomers(String key) throws ClassNotFoundException {
		try {
			filelistOfCustomer = FileHandeler.readFromFileCustomer();

			for (Customer element : filelistOfCustomer) {

				if (((Customer) element).getCustomerNum().equals(key)) {
					return element;
				}

			}
			return null;
		} catch (IOException e) {
			System.out.println("File not found! :(\n\n");
			return null;
		}
	}

	// search for a customer to make sure does not exist before adding again into
	// the file
	public static boolean searchCustomersExist(String key) throws ClassNotFoundException, IOException {
		filelistOfCustomer = FileHandeler.readFromFileCustomer();

		for (Customer element : filelistOfCustomer) {

			if (((Customer) element).getCustomerNum().equals(key)) {
				return true;
			}

		}
		return false;

	}

	public static ArrayList<Customer> getCustomerList() {

		return filelistOfCustomer;

	}

}