package by.epamtr.totalizator.service.imp;

public class Validator {
	public static boolean loginValidation(String login, String password) {
		// проверка логина и пароля
		if (login.isEmpty()) {
			return false;
		}
		if (password.isEmpty()) {
			return false;
		}

		return true;
	}

	public static boolean userInfoValidation(String firstName, String lastName, String login, String password,
			String repPassword, String sex, String eMail, String country, String city, String address) {

		if (firstName.isEmpty()) {
			return false;
		}
		if (lastName.isEmpty()) {
			return false;
		}
		if (login.isEmpty()) {
			return false;
		}
		if (password.isEmpty() || repPassword.isEmpty()) {
			return false;
		}
		if (!password.equals(repPassword)) {
			return false;
		}
		if (sex.isEmpty()) {
			return false;
		}
		if (eMail.isEmpty()) {
			return false;
		}
		if (country.isEmpty()) {
			return false;
		}

		return true;

	}
}