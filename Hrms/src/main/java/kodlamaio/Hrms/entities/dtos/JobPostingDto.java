package kodlamaio.Hrms.entities.dtos;


import java.sql.Date;
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
    //private Date deadlineDate; // bu kısım sorun olustumakta  
    private Instant createdAt;
	private String cityName;
	
}
