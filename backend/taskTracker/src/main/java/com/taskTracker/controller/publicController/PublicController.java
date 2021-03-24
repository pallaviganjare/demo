package com.taskTracker.controller.publicController;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskTracker.model.otp.Otp;
import com.taskTracker.model.user.User;
import com.taskTracker.service.ServiceLocator;

@RestController
@RequestMapping("/api/public")
public class PublicController {

	
	
	@PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Object> login(@RequestBody User user)
	{
		String token = ServiceLocator.getPublicService().login(user);
		HashMap<String,String> map = new HashMap<>();
		map.put("token", token);
		return ResponseEntity.ok(map);
	}
	@PostMapping(path = "/generateOtp",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Object> generateOTP(@RequestBody User user)
	{
		HashMap<String, String> map= new HashMap<String, String>();
		String emailId= ServiceLocator.getOtpService().generateOtp(user);
		map.put("emailId",emailId);
		return ResponseEntity.ok(map);
	}
	@PostMapping(path = "/verifyOtp",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Object> verifyOTP(@RequestBody Otp otp)
	{
		HashMap<String, String> map= new HashMap<String, String>();
		String token=ServiceLocator.getOtpService().verifyOtp(otp);
		map.put("token",token);
		return ResponseEntity.ok(map);
	}
}
