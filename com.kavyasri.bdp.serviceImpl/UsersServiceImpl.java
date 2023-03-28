package com.kavyasri.bdp.serviceImpl;



import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kavyasri.bdp.entity.Users;
import com.kavyasri.bdp.payload.CommonDto;
import com.kavyasri.bdp.repositary.UsersRepositary;
import com.kavyasri.bdp.service.UsersService;



@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepositary usersRepo;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	@Autowired
	private ModelMapper modelMapper;
	

	//post the data from user into db(store into db)
	@Override
	public Users createUser(Users users) {
		//encode the passwords in database
		users.setPassword(passEncoder.encode(users.getPassword()));
		Users savedUser=usersRepo.save(users);
		return savedUser;
	}


	@Override
	public List<CommonDto> getDetails(String bloodgroup) {
		
		usersRepo.findByBloodgroup(bloodgroup);
		//If user is present, get all the tasks of that user
		//In findAllByusersId,usersId is the column name(users_id) in task table
		List<Users> users=usersRepo.findAllByBloodgroup(bloodgroup);
		//converting Task list into TaskDto list using stream
		return users.stream().map(user->modelMapper.map(user,CommonDto.class)).collect(Collectors.toList());
	}


	@Override
	public List<CommonDto> findByGender(String gender) {
		List<Users> users= usersRepo.findByGender(gender);
		return users.stream().map(user->modelMapper.map(user,CommonDto.class)).collect(Collectors.toList());
	}
	
	@Override
	public List<CommonDto> findByBloodgroup(String bloodgroup) {
		List<Users> users= usersRepo.findByBloodgroup(bloodgroup);
		return users.stream().map(user->modelMapper.map(user,CommonDto.class)).collect(Collectors.toList());
	}


	@Override
	public List<CommonDto> findByBloodgroupAndGender(String bloodgroup, String gender) {
		List<Users> users=usersRepo.findByBloodgroupAndGender(bloodgroup, gender);
		return users.stream().map(user->modelMapper.map(user,CommonDto.class)).collect(Collectors.toList());
		
	}
	}

