package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	DataResult<List<JobPosting>>getByIsActiveTrue();//Tüm aktif iş ilanları
	DataResult<List<JobPosting>> getByIsActiveTrueOrderByCreatedAt();//iş ilanı aktif olanlar tarihe göre sıralanır
	DataResult<List<JobPosting>>getByIsActiveTrueAndEmployer_companyName(String companyName);//bir firmaya ait aktif iş ilanları sıralanır
	Result add(JobPosting jobPosting);//iş ilanı ekleme
	Result delete(JobPosting jobPosting);//iş ilanı silme
	Result update(JobPosting jobPosting);//iş ilanı güncelleme
	

}