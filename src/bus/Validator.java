package bus;

import java.util.regex.Pattern;

public class Validator {

	public static boolean ValiCustomerNumber(String customernum) {

		String addressPattern = "[0-9]{7}|[!]{1}";
		boolean b3 = Pattern.matches(addressPattern, customernum);

		if (b3 == true) {
			return true;
		}
		System.out.println("Please Enter A Valid Number With 7 Digit!\n");
		return false;
	}

	public static boolean ValiCustomerName(String customerName) {

		String addressPattern = "([a-z|A-Z]){2,10}";
		boolean b3 = Pattern.matches(addressPattern, customerName);

		if (b3 == true) {
			return true;
		}
		System.out.println("Please Enter A Valid Name With 2 to 10 Character!\n");
		return false;
	}

	public static boolean ValiCustomerPin(String customerPin) {

		String addressPattern = "[0-9]{4}";
		boolean b3 = Pattern.matches(addressPattern, customerPin);

		if (b3 == true) {
			return true;
		}
		System.out.println("Please Enter A Valid Pin With 4 Digit!\n");
		return false;
	}

	public static boolean ValiCustomerEmail(String customerEmail) {

		String addressPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		boolean b3 = Pattern.matches(addressPattern, customerEmail);

		if (b3 == true) {
			return true;
		}
		System.out.println("Please Enter A Valid Email Address!\n");
		return false;
	}

	public static boolean ValiAccountEnumType(String EnumNumber) {

		String addressPattern = "[1-3]{1}";
		boolean b3 = Pattern.matches(addressPattern, EnumNumber);

		if (b3 == true) {
			return true;
		}
		System.out.println("Please Enter A Number Between 1 to 3!\n");
		return false;
	}

	public static boolean ValiAccountBalance(String balance) {

		String addressPattern = "^\\d+(,\\d{3})*(\\.\\d{1,2})?$";

		boolean b3 = Pattern.matches(addressPattern, balance);

		if (b3 == true) {
			System.out.println(balance + "$ Added to the Account.");
			return true;
		}
		System.out.println("Please Enter A Valid Number!\nEX: 120.70\n");
		return false;
	}

	public static boolean ValiAccountNumber(String accountNumber) {

		String addressPattern = "[0-9]{5,10}";
		boolean b3 = Pattern.matches(addressPattern, accountNumber);

		if (b3 == true) {
			return true;
		}
		System.out.println("Please Enter A Valid Account Number With 5 to 10 Digit!\n");
		return false;
	}

	public static boolean ValiSwitchCase(String option) {

		String addressPattern = "[1-3]{1}";
		boolean b3 = Pattern.matches(addressPattern, option);

		if (b3 == true) {
			return true;
		}
		System.out.println("Please Enter A Correct Option Between 1 to 3!\n");
		return false;
	}

	public static boolean ValiAccountWithdraw(String balance) {

		String addressPattern = "^\\d+(,\\d{3})*(\\.\\d{1,2})?$";

		boolean b3 = Pattern.matches(addressPattern, balance);

		if (b3 == true) {
			return true;
		}
		System.out.println("Please Enter A Valid Number!\nEX: 120.70\n");
		return false;
	}

}
