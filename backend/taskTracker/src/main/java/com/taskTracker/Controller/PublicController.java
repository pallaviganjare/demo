package com.taskTracker.Controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskTracker.Config.JWTUtil;
import com.taskTracker.Model.User;
import com.taskTracker.repository.UserRepository;

@RestController
@RequestMapping("/api/public")
public class PublicController {

	private JWTUtil jwtUtil;
	private UserRepository userRepository;
	PublicController(JWTUtil jwtUtil,UserRepository userRepository)
	{
		this.jwtUtil=jwtUtil;
		this.userRepository=userRepository;
	}
	
	@PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Object> login(@RequestBody User user)
	{
		try 
		{
			User fetchedUser=userRepository.findByEmailId(user.getEmailId());
			String token;
			if(fetchedUser!=null && user.getPassword().equals(fetchedUser.getPassword()))
				token=jwtUtil.generateToken(user);
			else
				throw new BadCredentialsException("Invalid credentials");
			return ResponseEntity.ok()
					.body(
							Map.of(
									"token",token
							));
		}
		catch(BadCredentialsException e)
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
