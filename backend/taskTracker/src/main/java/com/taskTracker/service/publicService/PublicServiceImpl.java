package com.taskTracker.service.publicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskTracker.exceptionHandler.clientSideException.ClientSideException;
import com.taskTracker.model.user.User;
import com.taskTracker.repository.role.RoleRepository;
import com.taskTracker.repository.user.UserRepository;
import com.taskTracker.util.JWTUtil;

@Service
public class PublicServiceImpl  implements PublicService{

	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public String login(User user) {
			User fetchedUser = userRepository.findByEmailId(user.getEmailId());
			if(fetchedUser == null )
				throw new ClientSideException(401,"Invalid Username");
			if(!user.getPassword().equals(fetchedUser.getPassword()))
				throw new ClientSideException(401,"Invalid Password");
			fetchedUser.setRole(roleRepository.findById(fetchedUser.getRole_id()).get().getName());
			return jwtUtil.generateToken(fetchedUser);
	}
}
