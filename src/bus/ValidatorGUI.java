package bus;

import java.util.regex.Pattern;

public class ValidatorGUI {

	public static boolean ValiCustomerNumber(String customernum) {

		String addressPattern = "[0-9]{5}";
		boolean b3 = Pattern.matches(addressPattern, customernum);

		if (b3 == true) {
			return true;
		}
		return false;
	}

	public static boolean ValiCustomerName(String customerName) {

		String addressPattern = "([a-z|A-Z]){2,10}";
		boolean b3 = Pattern.matches(addressPattern, customerName);

		if (b3 == true) {
			return true;
		}
		return false;
	}

	public static boolean ValiCustomerPin(String customerPin) {

		String addressPattern = "[0-9]{4}";
		boolean b3 = Pattern.matches(addressPattern, customerPin);

		if (b3 == true) {
			return true;
		}
		return false;
	}

	public static boolean ValiCustomerEmail(String customerEmail) {

		String addressPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		boolean b3 = Pattern.matches(addressPattern, customerEmail);

		if (b3 == true) {
			return true;
		}
		return false;
	}

	public static boolean ValiCustomerUpdateNumber(String customernum) {

		String addressPattern = "[0-9]{5}";
		boolean b3 = Pattern.matches(addressPattern, customernum);

		if (b3 == true) {
			return true;
		}
		return false;
	}

}
