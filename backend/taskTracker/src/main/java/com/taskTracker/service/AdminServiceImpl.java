package com.taskTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taskTracker.model.User;
import com.taskTracker.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseEntity<Object> createUser(User user)
	{
		userRepository.insert(user);
		return ResponseEntity.ok().build();
	}
}
