package kodlamaio.Hrms.business.abstracts;


import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobPosting;
import kodlamaio.Hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {
	DataResult<List<JobPosting>>getByIsActiveTrue();//Tüm aktif iş ilanları
	//DataResult<List<JobPosting>> getByIsActiveTrueOrderByCreatedAt();//iş ilanı aktif olanlar tarihe göre sıralanır
	DataResult<List<JobPosting>>getByIsActiveTrueAndEmployer_companyName(String companyName);//bir firmaya ait aktif iş ilanları sıralanır
	Result add(JobPosting jobPosting);//iş ilanı ekleme
	Result delete(JobPosting jobPosting);//iş ilanı silme
	Result update(JobPosting jobPosting);//iş ilanı güncelleme
	DataResult<List<JobPosting>> getAllSortedIsActiveTrueAndCreatedAt(); // Aktif İş ilanlarını tarihe gore yakından uzaga sıralasın

	DataResult<List<JobPostingDto>> getJobPostingWithEmployerDetails();

}