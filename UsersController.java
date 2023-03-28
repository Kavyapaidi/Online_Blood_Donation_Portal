package com.kavyasri.bdp.controller;





import com.kavyasri.bdp.entity.Users;

import com.kavyasri.bdp.service.UsersService;
import com.kavyasri.bdp.payload.CommonDto;
import  com.kavyasri.bdp.payload.LoginDto;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth")
public class UsersController {
	@Autowired
	private UsersService uService;
	
	
	
	@Autowired
	private AuthenticationManager am;
	
	//post the data from user into db
	//requesting userDto to enter data 
	@PostMapping("/register")
	public ResponseEntity<Users> createUser(@RequestBody Users users)
	{
		//get the stored data(reponse) from db
		return new ResponseEntity<Users>(uService.createUser(users),HttpStatus.CREATED);
		//return status code as 201
	}
	
	//when you hit login
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginDto lDto)
	{
		//If the provided user details are in db then it will call CustomerUserDetailsService internally
      Authentication auth=am.authenticate(new UsernamePasswordAuthenticationToken(lDto.getEmail(),lDto.getPassword()));
      SecurityContextHolder.getContext().setAuthentication(auth);
//      return new ResponseEntity<>("User Logged in Successfully",HttpStatus.OK);
      return ResponseEntity.ok("User Logged in Successfully");
	}
	
	
	
//	//get user details based on bloodgroup
//			@GetMapping("/{bloodgroup}")
//			public ResponseEntity<List<CommonDto>> getDetails(@PathVariable(name="bloodgroup") String bloodgroup)
//			{
////				return new ResponseEntity<>(HhService.getHistory(usersId),HttpStatus.OK);
//				return ResponseEntity.ok().body(uService.getDetails(bloodgroup));
//			}
			
			//get user details based on gender
			@GetMapping("/users/gender")
			public ResponseEntity<List<CommonDto>> getGender(@RequestParam String gender)
			{
//				return new ResponseEntity<>(HhService.getHistory(usersId),HttpStatus.OK);
				return ResponseEntity.ok().body(uService.findByGender(gender));
			}
			
			//get user details based on bloodgroup
			@GetMapping("/users/bloodgroup")
			public ResponseEntity<List<CommonDto>> getUsersBybg(@RequestParam(required=false,defaultValue="b-positive") String bloodgroup 
					) {
				System.out.println(bloodgroup);
				return new ResponseEntity<List<CommonDto>>(uService.findByBloodgroup(bloodgroup), HttpStatus.OK);
			}
			
			//get user details based on both bloodgroup and gender
			@GetMapping("/users/bloodgroupandgender")
			public ResponseEntity<List<CommonDto>> getUsersBybgAndGender(@RequestParam(defaultValue="b-positive",required=false) String bloodgroup, 
					@RequestParam(defaultValue = "female") String gender) {
				return new ResponseEntity<List<CommonDto>>(uService.findByBloodgroupAndGender(bloodgroup,gender), HttpStatus.OK);
			}
			
			
			
			
			
			
			
			
			
			
			

		

}
