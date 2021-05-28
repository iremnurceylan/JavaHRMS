package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.Hrms.business.abstracts.JobSeekerService;
import kodlamaio.Hrms.core.adapters.MernisService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.Hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	private JobSeekerDao jobSeekerDao;
	private MernisService mernisService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,MernisService mernisService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisService = mernisService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş Arayanlar Listelendi");
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {

		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByEmail(email));
	}

	@Override
	public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
		
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByIdentityNumber(identityNumber));
	}
	
	private boolean validationForJobSeeker(JobSeeker jobSeeker) {
		if (Objects.isNull(jobSeeker.getIdentityNumber()) || Objects.isNull(jobSeeker.getFirstName()) || Objects.isNull(jobSeeker.getLastName()) 
				|| Objects.isNull(jobSeeker.getEmail()) || Objects.isNull(jobSeeker.getPassword()) || Objects.isNull(jobSeeker.getBirthDate())) {
			return false;
		}
		
	  return true;
	}
	
	private boolean checkIfEmailExists(String email) {
		if(this.jobSeekerDao.findByEmail(email) !=null) {
			return false;
		}
		return true;	
	}
	
	private boolean checkIfIdentityNumber(String identityNumber) {
		if(this.jobSeekerDao.findByIdentityNumber(identityNumber) !=null) {
			return false;
		}
		return true;	
	}
	
	private boolean checkIfRealPerson(JobSeeker jobSeeker) {
		if(!this.mernisService.checkIfRealPerson(Long.parseLong(jobSeeker.getIdentityNumber()), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getBirthDate())) {
			return false;
		}
		return true;
		
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) {
		if(!validationForJobSeeker(jobSeeker)) {
			return new ErrorResult("Eksik bilgi girdiniz.Lütfen bilgilerinizi kontrol ediniz.");
		}
		if(!checkIfRealPerson(jobSeeker)) {
			return new ErrorResult("Geçersiz.");
		}
		if(!checkIfEmailExists(jobSeeker.getEmail())) {
			return new ErrorResult("Bu mail adresi zaten mevcut.Lütfen yeniden deneyiniz");
		}
		if(!checkIfIdentityNumber(jobSeeker.getIdentityNumber())) {
			return new ErrorResult("Bu kişi zaten mevcut");
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi");
	}


}
