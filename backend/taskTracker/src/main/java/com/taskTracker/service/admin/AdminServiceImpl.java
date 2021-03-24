package com.taskTracker.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskTracker.exceptionHandler.clientSideException.ClientSideException;
import com.taskTracker.model.user.User;
import com.taskTracker.repository.user.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user)
	{
		if(userRepository.findByEmailId(user.getEmailId())!= null)
			throw new ClientSideException(409,"Email ID already exists");
		userRepository.insert(user);
		return user;
	}
	@Override
	public Map<String, List<String>> getRoles()
	{
		return null;
	}
}
