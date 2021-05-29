package kodlamaio.Hrms.entities.concretes;




import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers_activation_by_employees")
public class EmployerActivationByEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="confirmed_employee_id")
	private int confirmedEmployeeId;
	
	@Column(name="is_confirmed",columnDefinition="boolean default false")//ilk atama false
	private boolean isConfirmed;
	
	@Column(name="confirmed_date")
	private Instant confirmedDate =Instant.now();
	

	

}
