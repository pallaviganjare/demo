package com.taskTracker.Service;

import org.springframework.http.ResponseEntity;

import com.taskTracker.Model.User;

public interface AdminService {

	ResponseEntity<Object> createUser(User user);

}
