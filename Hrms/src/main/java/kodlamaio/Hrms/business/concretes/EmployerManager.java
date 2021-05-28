package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll(){
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş Verenler Listelendi");
	}


	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}
	
	//Kullanıcı bilgilendirme
	private boolean checkIfEmailExists(String email) {
		if(this.employerDao.findByEmail(email) != null) {
			return false;
		}
		return true;
	}
	
	private boolean validationForEmployer(Employer employer) {
		if (Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getWebAddress()) || Objects.isNull(employer.getEmail()) 
				|| Objects.isNull(employer.getPhoneNumber()) || Objects.isNull(employer.getPassword())){
			return false;
		}
		
	  return true;
	}
	
	//email ve domain aynı mı kontrolü
	private boolean checkIfEqualEmailAndDomain(String email,String webAddress) {
		String[] emailArray= email.split("@" , 2);
		String domain = webAddress.substring(4,webAddress.length());
		
		if(emailArray[1].equals(domain)) {
			return true;
		}
		return false;
	}

	@Override
	public Result add(Employer employer) {
	if(!this.checkIfEmailExists(employer.getEmail())){
		return new ErrorResult("Bu email adresi zaten mevcut.");
	}
	if(!this.validationForEmployer(employer)) {
		return new ErrorResult("Eksik bilgi girdiniz.Lütfen bilgilerinizi yeniden kontrol ediniz.");
	}
	if(!this.checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAddress())) {
		return new ErrorResult("Geçersiz mail adresi.Lütfen tekrar deneyiniz");
	}
		
		this.employerDao.save(employer);
		return new SuccessResult("İş veren başarıyla eklendi");
	}

}
