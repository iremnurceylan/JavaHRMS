package kodlamaio.Hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	 Employer findByEmail(String email);
	//Spring Data,bizim bu kayıtları email adına gore filtrelemek istedigimizi anlar ve buna gore
	// ...where email? seklinde sorguyu otomatık üretir.Metoda gecilen email parametresini
	//sorgu kosulundaki ilgili alana yerlestirir.Biz email yerine ... yazarsak o emaile sahip olan müsterilerin listesini elde ederiz

}
