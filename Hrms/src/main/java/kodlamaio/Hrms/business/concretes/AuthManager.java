package kodlamaio.Hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.AuthService;
import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.business.abstracts.JobSeekerService;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.core.verification.VerificationService;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.concretes.JobSeeker;


@Service
public class AuthManager implements AuthService{
	
	private EmployerService employerService;
	private JobSeekerService jobSeekerService;
	private VerificationService verificationService;

	public AuthManager(EmployerService employerService, JobSeekerService jobSeekerService,
			VerificationService verificationService) {
		super();
		this.employerService = employerService;
		this.jobSeekerService = jobSeekerService;
		this.verificationService = verificationService;
	}
	
	private boolean checkIfEqualPasswordAndConfirmPassword(String password , String confirmPassword) {
		if(!password.equals(confirmPassword)) {
			return false;
		}
		return true;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		if(!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {
			return new ErrorResult("Parola uyuşmuyor.Lütfen parolanızı yeniden giriniz.");
		}
		
		var result =this.employerService.add(employer);
		
		if(result.isSuccess()) {
			String code = this.verificationService.code();
			this.verificationService.sendVerificationCode(code);
			return new SuccessResult("Başarıyla kayıt olundu");
		}
		return new ErrorResult("Kayıt başarısız.Lütfen yeniden deneyiniz.");
	}

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker, String confirmPassword) {
		if(!checkIfEqualPasswordAndConfirmPassword(jobSeeker.getPassword(), confirmPassword)) {
			return new ErrorResult("Parola uyuşmuyor.Lütfen parolanızı yeniden giriniz.");
		}
		
		var result =this.jobSeekerService.add(jobSeeker);
		
		if(result.isSuccess()) {
			String code = this.verificationService.code();
			this.verificationService.sendVerificationCode(code);
			return new SuccessResult("Başarıyla kayıt olundu");
		}
		return new ErrorResult("Kayıt başarısız.Lütfen yeniden deneyiniz.");
		
		
	}


//	@Override
	//public Result verifyEmail(int user_id, String activationCode) {
		//var result = this.
	//	return null;
	//}
	
	

	
	
 
}
