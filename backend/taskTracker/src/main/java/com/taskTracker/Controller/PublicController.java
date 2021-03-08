package com.taskTracker.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskTracker.Model.Otp;
import com.taskTracker.Model.User;
import com.taskTracker.Service.ServiceLocator;

@RestController
@RequestMapping("/api/public")
public class PublicController {

	
	
	@PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Object> login(@RequestBody User user)
	{
		return ServiceLocator.getPublicService().login(user);
	}
	@PostMapping(path = "/generateOtp",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Object> generateOTP(@RequestBody User user)
	{
		return ServiceLocator.getOtpService().generateOtp(user);
	}
	@PostMapping(path = "/verifyOtp",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Object> verifyOTP(@RequestBody Otp otp)
	{
		return ServiceLocator.getOtpService().verifyOtp(otp);
	}
}
