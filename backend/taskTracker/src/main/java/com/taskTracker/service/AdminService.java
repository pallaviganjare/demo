package com.taskTracker.service;

import org.springframework.http.ResponseEntity;

import com.taskTracker.model.User;

public interface AdminService {

	ResponseEntity<Object> createUser(User user);

}
