package com.taskTracker.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.taskTracker.Config.JWTUtil;
import com.taskTracker.Model.User;
import com.taskTracker.repository.UserRepository;

@Service
public class PublicServiceImpl  implements PublicService{

	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<Object> login(User user) {
		try {
			User fetchedUser = userRepository.findByEmailId(user.getEmailId());
			String token;
			if (fetchedUser != null && user.getPassword().equals(fetchedUser.getPassword()))
				token = jwtUtil.generateToken(fetchedUser);
			else
				throw new BadCredentialsException("Invalid credentials");
			return ResponseEntity.ok().body(Map.of("token", token));
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
