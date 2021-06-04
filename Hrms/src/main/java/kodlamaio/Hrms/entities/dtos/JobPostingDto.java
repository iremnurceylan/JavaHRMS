package kodlamaio.Hrms.entities.dtos;



import java.time.Instant;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
     private int id;
	private String companyName;
	private String position;
	private int openPositionCount;
	private String description;
	private double  salaryMax;
	private double salaryMin;
     private Instant deadlineDate; // bu kısım sorun olustumakta  
	private String cityName;
	
}
