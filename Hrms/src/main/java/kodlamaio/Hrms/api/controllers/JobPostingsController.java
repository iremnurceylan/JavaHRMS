package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobPostingService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingsController {
	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobPosting>> getByIsActive(){
		return this.jobPostingService.getByIsActiveTrue();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.delete(jobPosting);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.update(jobPosting);
	}
	
	@GetMapping("/getByIsActiveTrueOrderByCreatedAt")
	public DataResult<List<JobPosting>> getByIsActiveTrueOrderByCreatedAt(){
		return this.jobPostingService.getByIsActiveTrueOrderByCreatedAt();
		}
	
	@GetMapping("/getByIsActivateTrueAndEmployer_CompanyName")
	public DataResult<List<JobPosting>> getByIsActiveTrueAndEmployer_companyName(@RequestParam String companyName){
	  return this.jobPostingService.getByIsActiveTrueAndEmployer_companyName(companyName);
	}
	
	@GetMapping("/getAllASC")
	public DataResult<List<JobPosting>> getAllSorted(){
		return this.jobPostingService.getAllSorted();
	}
	

}
