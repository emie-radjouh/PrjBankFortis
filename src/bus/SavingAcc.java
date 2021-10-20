package bus;

public class SavingAcc extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double annualInterest;
	private double annualGain;

	public SavingAcc(double accountBalance, String ownerID, double annualInterest, double annualGain) {
		super(accountBalance, ownerID);
		this.annualInterest = annualInterest;
		this.annualGain = annualGain;
	}

	public SavingAcc() {
		super();
		this.annualInterest = 0;
		this.annualGain = 0;
	}

	public double getAnnualInterest() {
		return annualInterest;
	}

	public void setAnnualInterest(double annualInterest) {
		this.annualInterest = annualInterest;
	}

	public double getAnnualGain() {
		return annualGain;
	}

	public void setAnnualGain(double annualGain) {
		this.annualGain = annualGain;
	}

	@Override
	public String toString() {
		return super.toString() + "SavingAcc [annualInterest=" + annualInterest + ", annualGain=" + annualGain + "]";
	}

}
