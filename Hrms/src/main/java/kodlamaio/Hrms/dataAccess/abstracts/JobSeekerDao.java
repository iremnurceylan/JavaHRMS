package kodlamaio.Hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao  extends JpaRepository<JobSeeker, Integer>{
	JobSeeker findByEmail(String email); 
	JobSeeker findByIdentityNumber(String identityNumber); 

}
