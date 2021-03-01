package com.taskTracker.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskTracker.Model.User;
import com.taskTracker.Service.ServiceLocator;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@PostMapping(path = "/createUser", consumes = "application/json", produces = "application/json")
	ResponseEntity<Object> createUser(@RequestBody User user)
	{
		return ServiceLocator.getAdminService().createUser(user);
	}
}
