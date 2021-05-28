package kodlamaio.Hrms.core.verification;

public interface VerificationService {
	void sendVerificationCode(String email);
	String code();


}
