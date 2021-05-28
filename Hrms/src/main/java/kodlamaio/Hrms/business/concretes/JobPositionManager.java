package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.Hrms.business.abstracts.JobPositionService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobDao;
import kodlamaio.Hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobDao jobDao;

	@Autowired
	public JobPositionManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobDao.findAll(), "Data listelendi");
	}
	
	//Kullanıcı bilgilendirme
	private boolean isPositionExist(String Position) {
		List<JobPosition> positionList = this.jobDao.findByPosition(Position);
		if( positionList.size() > 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public Result add(JobPosition jobposition) {
		if(!this.isPositionExist(jobposition.getPosition())) {
			return new ErrorResult("Bu pozisyon zaten sistemde mevcut.");
		}
		this.jobDao.save(jobposition);
		return new SuccessResult("İş pozisyonu eklendi");	
	}

}
