package com.kavyasri.bdp.security;


import com.kavyasri.bdp.entity.Users;
import com.kavyasri.bdp.exception.UserNotFound;
import com.kavyasri.bdp.repositary.UsersRepositary;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepositary urepo;
	
	//Load the userdetails
	//check user provided details and details in db are same or not.
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//getting all the details of user through email if that email is present in db
		Users user=urepo.findByEmail(email).orElseThrow(
				()->new UserNotFound(String.format("User with email:%s is not found:",email))
				);
		
		//everyone is admin here
		//everyone can add tasks and remove tasks
		//To store more than one role we are using set
//		Set<String> roles=new HashSet<String>();
//		roles.add("ROLE_ADMIN");
		
		
		//returns Users object which is User
//		return new  User(user.getEmail(),user.getPassword(),userAuthorities(roles));
		UserDetails ud = User.withUsername(user.getEmail()).password(user.getPassword()).authorities("ADMIN").build();
        return ud;
		
	}
	
	//return type is GrantedAuthority
	//converting set collection to GrantedAuthority Collection
	//Represents an authority granted to an Authentication object.
//	private Collection<? extends GrantedAuthority> userAuthorities(Set<String> roles)
//	{
//		return roles.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
//	}

}
