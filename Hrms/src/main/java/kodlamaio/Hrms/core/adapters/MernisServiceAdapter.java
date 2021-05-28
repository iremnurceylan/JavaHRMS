package kodlamaio.Hrms.core.adapters;

import java.util.Date;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.server.Client;
import kodlamaio.Hrms.mernis.FakeMernis;

@Service
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean checkIfRealPerson(long identityNumber, String firstName, String lastName, Date birthDate) {
		FakeMernis checkUser = new FakeMernis();
		boolean result = checkUser.userValidate(identityNumber,firstName, lastName,birthDate);
		return result;
	}
		
		

}
