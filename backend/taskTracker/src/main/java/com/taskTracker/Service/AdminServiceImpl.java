package com.taskTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println(""+userRepository.insert(user));
		return ResponseEntity.ok().build();
	}
}
