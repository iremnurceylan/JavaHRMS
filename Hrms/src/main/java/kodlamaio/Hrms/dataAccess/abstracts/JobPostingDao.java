package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.Hrms.entities.concretes.JobPosting;
import kodlamaio.Hrms.entities.dtos.JobPostingDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	List<JobPosting> getByActiveTrue();//Tüm aktif iş ilanları listelenir
	//List<JobPosting> getByActiveTrueOrderByCreatedAt();//iş ilanı aktif olanlar tarihe göre listelenir
	//@Query("From JobPosting where isOpen = true and employer_id=:id")
	List<JobPosting> getByActiveTrueAndEmployer_companyName(String companyName);//bir firmaya ait aktif iş ilanları listelenir
	  
	//@Query(value = "Select new kodlamaio.Hrms.entities.dtos.JobPostingDto(j.id,j.description,j.openPositionCount,j.salaryMax,j.salaryMin,j.deadlineDate,j.createdAt,e.companyName) From Employer e inner join e.jobPostings j", nativeQuery = true)
	//@Query("SELECT new kodlamaio.Hrms.entities.dtos.JobPostingDto(e.companyName,jb.position,j.openPositionCount,j,description,j.salaryMax,j.salaryMin,j.deadlineDate,j.createdAt)" +
	//"FROM JobPosting j" +
   //  " INNER JOIN j.jobPosition jb" +
   //  " INNER JOIN j.employer e ") 
	
	@Query("Select new kodlamaio.Hrms.entities.dtos.JobPostingDto(e.companyName, jp.position, j.openPositionCount, j.createdAt,j.description,j.salaryMax,j.salaryMin,j.deadlineDate From JobPosting j Inner Join j.employer e Inner Join j.jobPosition jp")
	List<JobPostingDto> getJobPostingWithEmployerDetails();
	
}
