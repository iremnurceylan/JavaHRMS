package kodlamaio.Hrms.core.verification;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationManager implements VerificationService{
	
	//Email'e kod gönderme
	@Override
	public void sendVerificationCode(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverification/" + uuid.toString();
		
	}
	
	//Random kod olustu
	@Override
	public String code() {
		UUID uuid = UUID.randomUUID();
		String verificationCode =uuid.toString();
		return verificationCode;

	}

}
