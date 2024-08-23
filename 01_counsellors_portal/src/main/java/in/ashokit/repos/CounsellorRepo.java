package in.ashokit.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entities.Counsellor;

public interface CounsellorRepo extends JpaRepository<Counsellor, Integer> {
	
	// select * from Counsellor_tbl where email = :email
	public Counsellor findByEmail(String email);
	
	//select * from Counsellor_tbl where email = :email and pwd = :pwd
	public Counsellor findByEmailAndPwd(String email,String pwd);

}
