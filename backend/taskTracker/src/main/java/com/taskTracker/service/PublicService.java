package com.taskTracker.service;

import org.springframework.http.ResponseEntity;

import com.taskTracker.model.User;

public interface PublicService {

	ResponseEntity<Object> login(User user);

}
