package com.kavyasri.bdp.repositary;

import java.util.List;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.kavyasri.bdp.entity.HealthHistory;
import com.kavyasri.bdp.entity.Users;




public interface UsersRepositary extends JpaRepository<Users,Long> {
	Optional<Users> findByEmail(String email);

//	Object findByBloodgroup(String bloodgroup);

	List<Users> findAllByBloodgroup(String bloodgroup);
	
	

	//@Query(u.fname)
	
	
//	@Query("select u.fname from Users u where u.gender=?1")
	List<Users> findByGender(String gender);
	
	List<Users> findByBloodgroup(String bloodgroup);
	
	List<Users> findByBloodgroupAndGender(String bloodgroup,String gender);

}

