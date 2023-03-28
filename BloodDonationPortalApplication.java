package com.kavyasri.bdp;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BloodDonationPortalApplication {

	
	public static void main(String[] args) {
		
		SpringApplication.run(BloodDonationPortalApplication.class, args);
		System.out.println("Blood Donation Portal is running on....");
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
}
