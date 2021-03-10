package com.taskTracker.service;

import org.springframework.http.ResponseEntity;

import com.taskTracker.model.Otp;
import com.taskTracker.model.User;

public interface OtpService {

	ResponseEntity<Object> generateOtp(User user);

	ResponseEntity<Object> verifyOtp(Otp otp);


}
