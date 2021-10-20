package bus;

public class CheckingAcc extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limitNumberTransaction = 4;

	public CheckingAcc(int accountBalance, String ownerID, int limitNumberTransaction) {
		super(accountBalance, ownerID);
		this.limitNumberTransaction = limitNumberTransaction;
	}

	public CheckingAcc(String ownerID, EnumAccount accounttype, double accountBalance) {
		super(ownerID, accounttype, accountBalance);
		if (limitNumberTransaction <= getTotalTransaction()) {
			System.out.println("you have reached to maximum free transaction number!");
		}
		this.limitNumberTransaction = limitNumberTransaction;
	}

	public CheckingAcc() {
		super();
		this.limitNumberTransaction = 0;
	}

	public int getLimitNumberTransaction() {
		return limitNumberTransaction;
	}

	public void setLimitNumberTransaction(int limitNumberTransaction) {
		this.limitNumberTransaction = limitNumberTransaction;
	}

	@Override
	public String toString() {
		return super.toString() + "CheckingAcc [accountNum=" + getAccountNum() + ", accountType=" + getAccountType()
				+ ", openDate=" + getOpenDate() + ", accountBalance=" + getAccountBalance() + ", Customer ID="
				+ getOwnerID() + ", totalTransaction=" + getTotalTransaction() + " limitNumberTransaction="
				+ limitNumberTransaction + "]";

	}

}
