package kodlamaio.Hrms.mernis;

import java.util.Date;

public class FakeMernis {
	public boolean userValidate(long identityNumber,String firstName,String lastName,Date birtDate) {
		System.out.println("Doğrulama Başarılı" + firstName + " " + lastName);
		return true;
	}

}
