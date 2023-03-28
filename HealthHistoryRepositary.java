package com.kavyasri.bdp.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kavyasri.bdp.entity.HealthHistory;


public interface HealthHistoryRepositary extends JpaRepository<HealthHistory,Long> {

	List<HealthHistory> findAllByusersId(long userid);
	
	  @Query("select h from HealthHistory h join h.users u on u.id=h.users.id where u.gender=?1")
	  List<HealthHistory> findHealthHistoryByGender(String gender);

}
