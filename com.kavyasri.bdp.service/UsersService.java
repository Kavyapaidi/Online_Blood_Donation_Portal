package com.kavyasri.bdp.service;




import java.util.List;


//import org.springframework.data.jpa.repository.Query;

import com.kavyasri.bdp.entity.Users;
import com.kavyasri.bdp.payload.CommonDto;


public interface UsersService {
	public Users createUser(Users users);
	
	//Get details based on blood group
//	@Query("select * from users where users.bloodgroup=b+")
	public List<CommonDto> getDetails(String bloodgroup);
	
	public List<CommonDto> findByGender(String gender);
	
	public List<CommonDto> findByBloodgroup(String bloodgroup);
	
	public List<CommonDto> findByBloodgroupAndGender(String fname,String gender);

	
}
