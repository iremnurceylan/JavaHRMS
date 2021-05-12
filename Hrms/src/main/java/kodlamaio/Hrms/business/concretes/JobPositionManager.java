package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobPositionService;
import kodlamaio.Hrms.dataAccess.abstracts.JobDao;
import kodlamaio.Hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobDao jobDao;

	@Autowired
	public JobPositionManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public List<JobPosition> getAll() {
	
		return this.jobDao.findAll();
	}

}
