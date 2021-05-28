package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();//Employer listele
	Result add(Employer employer);//Employer ekleme
	DataResult<Employer> getByEmail(String email);//Daha önce kayıtlı bir e-posta var ise kayıt gerceklestirilmez.Kullanıcı uyarılır maddesi


}
