package com.kavyasri.bdp.securityconfig;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	//----------------------------------------------------------------------
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		//bean should return http response
		//bean should authorize all the requests
		//we should give access to url to authenticate users
		//any request should be authenticated by the bean
		http
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/api/**").permitAll()
		.anyRequest()
		.authenticated();
		
		//return this http build
		return http.build();
		
	}
	
	//am authenticates the user provided password(type=password) with password(encrypted) in db
	//Both passwords are of same type(encrypted)
	@Bean
	public AuthenticationManager am(AuthenticationConfiguration ac) throws Exception
	{
		
	return ac.getAuthenticationManager();
	}
	//--------------------------------------------------------------------------------------
	


}
