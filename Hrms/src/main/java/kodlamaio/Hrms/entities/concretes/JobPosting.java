package kodlamaio.Hrms.entities.concretes;

import java.sql.Date;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_postings")
public class JobPosting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	//@Column(name="job_position_id")
	//private int jobPositionId;
	
	@Column(name="description")
	private String description;
	
	//@Column(name="city_id")
	//private int cityId;
	
	@Column(name="salary_max")
	private double salaryMax;
	
	@Column(name="salary_min")
	private double salaryMin;
	
	@Column(name="open_position_count")
	private int openPositionCount;
	
	@Column(name="deadline_date")
	private Date deadlineDate;
	
	@Column(name="created_at")
	private Instant createdAt = Instant.now();
	
	@Column(name="is_active",columnDefinition = "boolean default true")
    private boolean active = true;
	
	//@Column(name="employer_id")
	//private int employerId;
	
	@ManyToOne()
	@JoinColumn(name= "city_id")
	private City city; //Çok ilan tek sehir (36-37 satır kalkar)
	
	@ManyToOne()
	@JoinColumn(name= "employer_id")
	private Employer employer; //Bir iş veren cok ilan (57-58 kalkar)
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition; //30-31 kalkar

}
