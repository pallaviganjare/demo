package com.taskTracker.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	
	@Override
	public Map<Object, Object> getUsers(User user)
	{
		Map<Object,Object> map=new HashMap<Object, Object>();
		float pageCount =(float)userRepository.count()/(float)user.getRowCount();
		map.put("totalPage",Math.ceil(pageCount));
		PageRequest request = PageRequest.of((int)user.getPageNo()-1,(int)user.getRowCount());
		map.put("value",userRepository.findAll(request).getContent());
		return map;
	}
}
