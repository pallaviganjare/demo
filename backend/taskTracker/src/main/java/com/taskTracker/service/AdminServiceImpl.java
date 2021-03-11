package com.taskTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskTracker.exceptionHandler.ClientSideException;
import com.taskTracker.model.User;
import com.taskTracker.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean createUser(User user)
	{
		if(userRepository.findByEmailId(user.getEmailId())!= null)
			throw new ClientSideException(401,"Email ID already exists");
		userRepository.insert(user);
		return true;
	}
}
