package com.taskTracker.Service;

import org.springframework.http.ResponseEntity;

import com.taskTracker.Model.User;

public interface PublicService {

	ResponseEntity<Object> login(User user);

}
