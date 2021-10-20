package client;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import data.DataCollection;
import data.FileHandeler;
import bus.Customer;
import bus.Account;
import bus.CheckingAcc;
import bus.EnumAccount;
import bus.Validator;

public class main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Scanner scanner = new Scanner(System.in);
		String inputKey;

		File file = new File("src//data// customers.ser");
		boolean fileExists;

		do {
			System.out.println("1 - Add a new customer.");
			System.out.println("2 - Remove a customer.");
			System.out.println("3 - Display all the customers.");
			System.out.println("4 - Open a new account.");
			System.out.println("5 - Remove an account.");
			System.out.println("6 - Display all the accounts.");
			System.out.println("7 - Enter to an account for more servises.");
			System.out.println("8 - Exit");
			System.out.print("\t Please enter your option: ");

			// Declaring variable to store data
			String customerNum, customerName, customerPin, customerEmail, accountNum, swichInput, balance,
					depositAamount, withdrawAmount;
			EnumAccount accountType;

			inputKey = scanner.next();
			switch (inputKey) {
			case "1": {
				System.out.print("\t((ADD A NEW CUSTOMER))\n\n");
				fileExists = file.exists();

				// Get customer number with validation
				do {
					System.out.println("Customer Number: \n");
					customerNum = scanner.next();
				} while (Validator.ValiCustomerNumber(customerNum) == false);

				// Get customer name with validation
				do {
					System.out.println("Customer Name: \n");
					customerName = scanner.next();

				} while (Validator.ValiCustomerName(customerName) == false);

				// Get Customer Pin with validation
				do {
					System.out.println("Customer Pin: \n");
					customerPin = scanner.next();

				} while (Validator.ValiCustomerPin(customerPin) == false);

				do {
					System.out.println("Customer Email: \n");
					customerEmail = scanner.next();

				} while (Validator.ValiCustomerEmail(customerEmail) == false);

				// Check if the file exists then check all customer number to avoid saving a
				// repeated number
				if (fileExists == true) {
					// check for all customer numbers
					if (DataCollection.searchCustomersExist(customerNum) == true) {
						System.out.println("The Account Number " + customerNum + " already Exists!");

					} else {
						// create new customer with parameters
						Customer newCustomer = null;
						newCustomer = new Customer(customerNum, customerName, customerPin, customerEmail);

						// A customer must have at least a checking account.
						// Create new accout type checking
						Account defaultAccount = null;
						defaultAccount = new Account(newCustomer.getCustomerNum(), EnumAccount.Checking, 0.0);

						// Save new customer and new account to data collection
						DataCollection.addCustomer(newCustomer);
						DataCollection.addAccount(defaultAccount);
						System.out.println("Customer Number " + customerNum + " Successfully Added To File.");
					}

				} else {

					Customer newCustomer = null;
					newCustomer = new Customer(customerNum, customerName, customerPin, customerEmail);

					// Create new accout type checking
					Account defaultAccount = null;
					defaultAccount = new Account(newCustomer.getCustomerNum(), EnumAccount.Checking, 0.0);

					// Save new customer and new account to data collection
					DataCollection.addCustomer(newCustomer);
					DataCollection.addAccount(defaultAccount);
					System.out.println("Customer Number " + customerNum + " Successfully Added To File.");

				}

				System.out.println("\n\n\n\n\n\n");
				break;
			}
			case "2": {
				System.out.print("\t((REMOVE AN EXISTING CUSTOMER))\n\n");

				// Get a customer number for deleting from data collection
				do {
					System.out.println("Please enter a customer number: \n");
					customerNum = scanner.next();

				} while (Validator.ValiCustomerNumber(customerNum) == false);

				// Check if customer exist then remove it from data collection
				DataCollection.removeCustomer(customerNum);
				System.out.println("\n\n\n\n\n\n");
				break;
			}
			case "3": {
				System.out.print("\t((ALL THE CUSTOMERS))\n\n");

				// Open the file, deserialization and show all customers
				DataCollection.allCustomers();
				System.out.println("\n\n");
				break;
			}
			case "4": {
				System.out.print("\t((OPEN A NEW ACCOUNT))\n\n");

				// Get customer number with validation
				do {
					System.out.print("Please enter a customer number: \n");
					customerNum = scanner.next();
				} while (Validator.ValiCustomerNumber(customerNum) == false);

				// check the number in data collection if exist then run the request
				if (DataCollection.searchCustomers(customerNum) != null) {
					// We can show the customer information here!

					// Get Enum type by menu and validation
					do {
						System.out.println("Please select the account type: \n");
						accountType = EnumAccount.Undefined;
						System.out.println(" \t 1- Checking");
						System.out.println(" \t 2- Saving");
						System.out.println(" \t 3- Credit");
						swichInput = scanner.next();
						switch (swichInput) {
						case "1":
							accountType = EnumAccount.Checking;
							break;
						case "2":
							accountType = EnumAccount.Saving;
							break;
						case "3":
							accountType = EnumAccount.Credit;
							break;
						default:
							accountType = EnumAccount.Undefined;
							break;
						}

					} while (Validator.ValiAccountEnumType(swichInput) == false);

					// Get balence with validation

					do {
						System.out.println("Please enter account balance: \n");
						balance = scanner.next();

					} while (Validator.ValiAccountBalance(balance) == false);

					// Create an account with all validated information and save to file
					Account newAccount = null;
					newAccount = new Account(customerNum, accountType, Double.valueOf(balance));
					DataCollection.addAccount(newAccount);

				} else {
					System.out.println("This customer does not exist!");
				}

				System.out.println("\n\n");
				break;
			}
			case "5": {
				System.out.print("\t((REMOVE AN ACCOUNT))\n\n");

				// Get account number to remove it from file
				do {
					System.out.print("Enter the account number: \n");
					accountNum = scanner.next();

				} while (Validator.ValiAccountNumber(accountNum) == false);

				// Search and if exist then remove it
				if (DataCollection.searchAccount(accountNum) == null) {
					System.out.println("This Account does not exist!");
				} else {
					DataCollection.removeAccount(accountNum);
				}

				break;
			}
			case "6": {
				System.out.print("\t((ALL THE ACCOUNTS))\n\n");

				// Provide all data from serializable file
				DataCollection.allAccounts();
				System.out.println("\n\n");
				break;
			}
			case "7": {
				System.out.print("\t((MORE SERVISES))\n\n");

				// Get the account number for entering to account for more services
				// With Validation
				do {
					System.out.println("Please enter your account number: \n");
					accountNum = scanner.next();
				} while (Validator.ValiAccountNumber(accountNum) == false);

				// Check if account exist or not
				if (DataCollection.searchAccount(accountNum) == null) {
					System.out.println("This account does not exist!");
				} else {
					System.out.println("\t((WELCOME))\n\n");

					// Validating the input for Switch case
					do {
						System.out.println("Please select your servise: \n");
						System.out.println(" \t 1- Deposit");
						System.out.println(" \t 2- Withdraw");
						System.out.println(" \t 3- Account Information");
						swichInput = scanner.next();

						switch (swichInput) {
						case "1":
							System.out.println("\t((DEPOSIT))\n\n");

							// Get the amount for deposit with validation
							do {
								System.out.println("Please enter the amount: \n");
								depositAamount = scanner.next();

							} while (Validator.ValiAccountBalance(depositAamount) == false);

							// Save deposit to file
							DataCollection.depositAccount(accountNum, Double.valueOf(depositAamount));
							break;
						case "2":
							System.out.println("\t((WITHDRAW))\n\n");

							// Get the amount for withdraw with validation
							do {
								System.out.println("Please enter the amount: \n");
								withdrawAmount = scanner.next();

							} while (Validator.ValiAccountWithdraw(withdrawAmount) == false);

							// save withdraw to file
							DataCollection.withdrawAccount(accountNum, Double.valueOf(withdrawAmount));
							break;
						case "3":
							// Read data from the file
							DataCollection.searchAccountInfo(accountNum);
							break;
						default:
							System.out.println("Your option is not valid.");
						}
					} while (Validator.ValiSwitchCase(swichInput) == false);
				}

				System.out.println("\n\n");
				break;
			}

			case "8": {
				System.out.println("Option 8 is entered...");
				break;
			}

			default:
				System.out.println("No Valid Input Entered!!\n\n");
				continue;
			}
		} while (!inputKey.equals("8"));

		System.out.println("Application is closed successfuly!");

		scanner.close();
	}

}