package bus;

import java.time.LocalDate;

public class Transaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7248504969072653604L;
	private String transactionNum;
	private String description;
	private LocalDate transactionDate;
	private double transactionAmount;
	private double balance;
	private EnumTransaction transactionType;

	public Transaction(String description, double transactionAmount, EnumTransaction transactionType) {
		super();
		this.transactionNum = 10 + (int) (Math.random() * 899) + "";
		this.description = description;
		this.transactionDate = LocalDate.now();
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
	}

	// Check the default value for amount and balance
	public Transaction() {
		super();
		this.transactionNum = "Undefined";
		this.description = "Undefined";
		this.transactionDate = LocalDate.now();
		this.transactionAmount = -1;
		this.balance = -1;
		this.transactionType = EnumTransaction.Undefined;
	}

	public String getTransactionNum() {
		return transactionNum;
	}

	public void setTransactionNum(String transactionNum) {
		this.transactionNum = transactionNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public EnumTransaction getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(EnumTransaction transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transaction [transactionNum=" + transactionNum + ", description=" + description + ", transactionDate="
				+ transactionDate + ", transactionAmount=" + transactionAmount + ", balance=" + balance
				+ ", transactionType=" + transactionType + "]";
	}

}
