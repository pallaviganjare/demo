package com.taskTracker.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taskTracker.Model.User;
import com.taskTracker.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseEntity<Object> createUser(User user)
	{
		if(userRepository.findByEmailId(user.getEmailId())!= null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","Email ID already exists"));
		userRepository.insert(user);
		return ResponseEntity.ok().build();
	}
}
