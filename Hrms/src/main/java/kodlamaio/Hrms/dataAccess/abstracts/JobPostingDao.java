package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.Hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	List<JobPosting> getByActiveTrue();//Tüm aktif iş ilanları listelenir
	List<JobPosting> getByActiveTrueOrderByCreatedAt();//iş ilanı aktif olanlar tarihe göre listelenir
	//@Query("From JobPosting where isOpen = true and employer_id=:id")
	List<JobPosting> getByActiveTrueAndEmployer_companyName(String companyName);//bir firmaya ait aktif iş ilanları listelenir
	
	
}
