package bus;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
import java.time.LocalDate;
import bus.Customer;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1183395108463511269L;
	private String accountNum;
	// private String accountPIN;
	private EnumAccount accountType;
	private LocalDate openDate;
	private double accountBalance;
	private Transaction[] listTransactions = new Transaction[100];
	private String ownerID;
	private EnumTransaction transactionType;
	private int totalTransaction;

	// Constructors
	public Account() {
		super();
		this.accountNum = 10000 + (int) (Math.random() * 89999) + "";
		// this.accountPIN = "Undefined";
		this.accountType = EnumAccount.Undefined;
		this.openDate = openDate.now();
		this.accountBalance = 0;
		this.ownerID = "Undefined";
		this.totalTransaction = 0;
	}

	public Account(double accountBalance, String ownerID) {
		super();
		this.accountNum = 10000 + (int) (Math.random() * 89999) + "";
		// this.accountPIN = accountPIN;
		this.openDate = openDate.now();
		this.accountBalance = accountBalance;
		this.ownerID = ownerID;
		this.totalTransaction = 0;

	}

	public Account(String ownerID, EnumAccount accounttype, double accountBalance) {
		super();
		this.accountNum = 10000 + (int) (Math.random() * 89999) + "";
		this.openDate = openDate.now();
		this.accountBalance = accountBalance;
		this.ownerID = ownerID;
		this.accountType = accounttype;
		this.totalTransaction = 0;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public EnumAccount getAccountType() {
		return accountType;
	}

	public void setAccountType(EnumAccount accountType) {
		this.accountType = accountType;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Transaction[] getListTransactions() {
		return listTransactions;
	}

	public void setListTransactions(Transaction[] listTransactions) {
		this.listTransactions = listTransactions;
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	public EnumTransaction getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(EnumTransaction transactionType) {
		this.transactionType = transactionType;
	}

	public int getTotalTransaction() {
		return totalTransaction;
	}

	public void setTotalTransaction(int totalTransaction) {
		this.totalTransaction = totalTransaction;
	}

	// Have to add the time DATE
	public void deposit(double amount) {

		accountBalance += amount;
		Transaction transaction = new Transaction();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		// transaction.setTransactionDate();
		transaction.setTransactionAmount(amount);
		transaction.setBalance(accountBalance);
		transaction.setTransactionType(EnumTransaction.Deposit);
		listTransactions[totalTransaction++] = transaction;

	}

	public void withdrawl(double amount) {

		accountBalance -= amount;

		Transaction transaction = new Transaction();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		// transaction.setTransactionDate();
		transaction.setTransactionAmount(amount);
		transaction.setBalance(accountBalance);
		transaction.setTransactionType(EnumTransaction.Withdrawl);
		listTransactions[totalTransaction++] = transaction;

	}

	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", accountType=" + accountType + ", openDate=" + openDate
				+ ", accountBalance=" + accountBalance + ", Customer ID=" + ownerID + ", totalTransaction="
				+ totalTransaction + "]";
	}

}
