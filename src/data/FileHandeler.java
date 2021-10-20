package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bus.Account;
import bus.CheckingAcc;
import bus.Customer;

//creating a main class for reading and writing to serializable file
public class FileHandeler {
	// -------------------------- Account ---------------------------------------
	// creating a new path for Account file
	public static String filePathAccount = "src//data// accounts.ser";

	// creating a method for writing to Account file
	public static void writeToFileAccount(ArrayList<Account> list) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePathAccount);
		@SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);

	}

	// creating a method to read from file
	public static ArrayList<Account> readFromFileAccount() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream(filePathAccount);

		ObjectInputStream ois = new ObjectInputStream(fis);

		@SuppressWarnings("unchecked")
		ArrayList<Account> listFromFile = (ArrayList<Account>) ois.readObject();

		ois.close();
		return listFromFile;
	}
	// -------------------------- Checjing Account
	// ---------------------------------------

	// creating a method for writing to Account file CheckingAcc
	public static void writeToFileCheckingAcc(ArrayList<CheckingAcc> list) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePathAccount);
		@SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);

	}

	// creating a method to read from file CheckingAcc
	public static ArrayList<CheckingAcc> readFromFileCheckingAcc() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream(filePathAccount);

		ObjectInputStream ois = new ObjectInputStream(fis);

		@SuppressWarnings("unchecked")
		ArrayList<CheckingAcc> listFromCheckingAccFile = (ArrayList<CheckingAcc>) ois.readObject();

		ois.close();
		return listFromCheckingAccFile;
	}

	// -------------------------------------
	// creating a new path for Customer file
	private static String filePathCustomer = "src//data// customers.ser";

	// creating a method for writing to Customer file
	public static void writeToFileCustomer(ArrayList<Customer> list) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePathCustomer);
		@SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);

	}

	// creating a method to read from file
	public static ArrayList<Customer> readFromFileCustomer() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream(filePathCustomer);

		ObjectInputStream ois = new ObjectInputStream(fis);

		@SuppressWarnings("unchecked")
		ArrayList<Customer> listFromFile = (ArrayList<Customer>) ois.readObject();

		ois.close();
		return listFromFile;
	}

}