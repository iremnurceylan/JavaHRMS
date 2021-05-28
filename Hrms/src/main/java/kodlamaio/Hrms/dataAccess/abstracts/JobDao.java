package kodlamaio.Hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.JobPosition;
import kodlamaio.Hrms.entities.concretes.JobSeeker;

public interface JobDao extends JpaRepository<JobPosition,Integer> {
	List<JobPosition> findByPosition(String position);
}
