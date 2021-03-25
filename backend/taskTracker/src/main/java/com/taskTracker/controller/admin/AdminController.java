package com.taskTracker.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskTracker.model.user.User;
import com.taskTracker.service.ServiceLocator;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@PostMapping(path = "/createUser", consumes = "application/json", produces = "application/json")
	ResponseEntity<Object> createUser(@RequestBody User user)
	{
			return ResponseEntity.ok().body(ServiceLocator.getAdminService().createUser(user));
	}
	@GetMapping(path = "/getRoles", produces = "application/json")
	ResponseEntity<Object> getRoles()
	{
			return null;
	}
	@PostMapping(path = "/getUsers", consumes = "application/json", produces = "application/json")
	ResponseEntity<Object> getUsers(@RequestBody User user)
	{
			return ResponseEntity.ok().body(ServiceLocator.getAdminService().getUsers(user));
	}
}
