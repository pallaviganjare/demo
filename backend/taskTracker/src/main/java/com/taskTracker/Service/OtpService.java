package com.taskTracker.Service;

import org.springframework.http.ResponseEntity;

import com.taskTracker.Model.Otp;
import com.taskTracker.Model.User;

public interface OtpService {

	ResponseEntity<Object> generateOtp(User user);

	ResponseEntity<Object> verifyOtp(User user, Otp otp);


}
