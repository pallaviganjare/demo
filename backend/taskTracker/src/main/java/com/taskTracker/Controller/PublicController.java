package com.taskTracker.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskTracker.Model.User;
import com.taskTracker.Service.ServiceLocator;

@RestController
@RequestMapping("/api/public")
public class PublicController {

	
	
	@PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Object> login(@RequestBody User user)
	{
		return ServiceLocator.getPublicService().login(user);
	}
}
