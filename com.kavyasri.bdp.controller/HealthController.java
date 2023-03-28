package com.kavyasri.bdp.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kavyasri.bdp.payload.HealthHistoryDto;
import com.kavyasri.bdp.service.HealthHistoryService;




@RestController
@RequestMapping("/api")
public class HealthController {
	
	@Autowired
	private HealthHistoryService HhService;
	
	//save the tasks for that userid
	@PostMapping("/{users_id}/history")
	//Requesting user to enter history details
	public ResponseEntity<HealthHistoryDto> saveHistory(
			@PathVariable(name="users_id") long usersId,
			@RequestBody HealthHistoryDto Hhdto)
	{
		//get the stored data(reponse) from db
        return new ResponseEntity<HealthHistoryDto>(HhService.saveHistory(usersId,Hhdto),HttpStatus.CREATED);
		//return status code as 201
		
	}
	
	
	
	//get healthhistory of that user
		@GetMapping("/{users_id}/history")
		public ResponseEntity<List<HealthHistoryDto>> getHistory(
				@PathVariable(name="users_id") long usersId)
		{
//			return new ResponseEntity<>(HhService.getHistory(usersId),HttpStatus.OK);
			return ResponseEntity.ok().body(HhService.getHistory(usersId));
		}
		
		
		//get healthhistory of that user
				@GetMapping("/history/{gender}")
				public ResponseEntity<List<HealthHistoryDto>> getHistoryByGender(
						@PathVariable(name="gender") String gender)
				{
//					return new ResponseEntity<>(HhService.getHistory(usersId),HttpStatus.OK);
					return ResponseEntity.ok().body(HhService.getHistoryByGender(gender));
				}
	
}


