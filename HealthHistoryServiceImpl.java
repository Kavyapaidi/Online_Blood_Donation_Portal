package com.kavyasri.bdp.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavyasri.bdp.entity.HealthHistory;
import com.kavyasri.bdp.entity.Users;
import com.kavyasri.bdp.exception.UserNotFound;
import com.kavyasri.bdp.payload.CommonDto;
import com.kavyasri.bdp.payload.HealthHistoryDto;
import com.kavyasri.bdp.repositary.HealthHistoryRepositary;
import com.kavyasri.bdp.repositary.UsersRepositary;
import com.kavyasri.bdp.service.HealthHistoryService;




@Service
public class HealthHistoryServiceImpl implements HealthHistoryService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UsersRepositary urepo;
	
	@Autowired
	private HealthHistoryRepositary Hhrepo;
	
	
    //store the history for that userid into db
	@Override
	public HealthHistoryDto saveHistory(long userid, HealthHistoryDto Hhdto) {
		//But first check whether that userid is present or not
//		Users user=urepo.findById(userid).get();//if present
		Users user=urepo.findById(userid).orElseThrow(
				()->new UserNotFound(String.format("user id %d is not found", userid))
				);
		//converting  Hhdto to HealthHistory
		HealthHistory healthhistory=modelMapper.map(Hhdto,HealthHistory.class);
		//setting the user
		healthhistory.setUsers(user);
		//save the healthhistory into database
		HealthHistory savedHistory=Hhrepo.save(healthhistory);
		//again convert the savedHistory into HealthHistoryDto
		HealthHistoryDto HhDto=modelMapper.map(savedHistory,HealthHistoryDto.class);
		//return TaskDto
		return HhDto;
	}


	//get the health history of that user
	@Override
	public List<HealthHistoryDto> getHistory(long userid) {
		urepo.findById(userid).orElseThrow(
				()->new UserNotFound(String.format("user id %d is not found", userid))
				);
		//If user is present, get history of that user
		//In findAllByusersId,usersId is the column name(users_id) in health_history table
		List<HealthHistory> healthhistory=Hhrepo.findAllByusersId(userid);
		//converting HealthHistory list into HealthHistoryDto list using stream
		return healthhistory.stream().map(history->modelMapper.map(history,HealthHistoryDto.class)).collect(Collectors.toList());
	}


	@Override
	public List<HealthHistoryDto> getHistoryByGender(String gender) {
		List<HealthHistory> healthh=Hhrepo.findHealthHistoryByGender(gender);
		healthh.forEach(x->System.out.println(x.getUsers().toString()));
		return healthh.stream().map(healthhistory->modelMapper.map(healthhistory,HealthHistoryDto.class)).collect(Collectors.toList());
	
	}
}



	


