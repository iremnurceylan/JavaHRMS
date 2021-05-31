package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobPostingService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.Hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{
	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getByIsActiveTrue() {
	  return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByActiveTrue(), "Tüm aktif iş ilanları listelendi");
		// null;
	}

	@Override
	public DataResult<List<JobPosting>> getByIsActiveTrueOrderByCreatedAt() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByActiveTrueOrderByCreatedAt(), "Listelendi");
		//return null;
	}
	
	@Override
     public DataResult<List<JobPosting>> getByIsActiveTrueAndEmployer_companyName(String companyName ) {
	   return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByActiveTrueAndEmployer_companyName(companyName), "Listelendi");
		//return null;
	}

	
	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı başarıyla eklendi");
	}

	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("İş ilanı başarıyla silindi");
	}

	@Override
	public Result update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı başarıyla güncellendi");
	}

	//Yeni ekledım iş ilanları yakın tarıhten uzaga dogru sıralandı
	@Override
	public DataResult<List<JobPosting>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC,"deadlineDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort), "Yakın tarihli iş ilanları listelendi");
	}

}
