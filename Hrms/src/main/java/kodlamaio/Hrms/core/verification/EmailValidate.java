package kodlamaio.Hrms.core.verification;

import java.util.regex.Pattern;

public class EmailValidate {
	
	private static final String email_pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	 
	public static boolean isEmailValid(String emailInput) {
	
		Pattern pattern = Pattern.compile(email_pattern, Pattern.CASE_INSENSITIVE);
     
		return pattern.matcher(emailInput).find();
	}

}
