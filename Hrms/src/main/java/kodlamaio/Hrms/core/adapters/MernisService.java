package kodlamaio.Hrms.core.adapters;

import java.util.Date;

public interface MernisService {
	public boolean checkIfRealPerson(long identityNumber,String firstName,String lastName,Date birthDate);

}
