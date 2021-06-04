package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.Hrms.entities.concretes.JobPosting;
import kodlamaio.Hrms.entities.dtos.JobPostingDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	//Satır 14 service ve manager ları silinebilir
	List<JobPosting> getByActiveTrue();//Tüm aktif iş ilanları listelenir
	//List<JobPosting> getByActiveTrueOrderByCreatedAt();//iş ilanı aktif olanlar tarihe göre listelenir
	List<JobPosting> getByActiveTrueAndEmployer_companyName(String companyName);//bir firmaya ait aktif iş ilanları listelenir

	@Query("Select new kodlamaio.Hrms.entities.dtos.JobPostingDto(j.id,e.companyName, jp.position, j.openPositionCount,j.description,j.salaryMax,j.salaryMin,j.deadlineDate,c.name) From JobPosting j Inner Join j.employer e Inner Join j.jobPosition jp  Inner join j.city c ")
	List<JobPostingDto> getJobPostingWithEmployerDetails();
}
