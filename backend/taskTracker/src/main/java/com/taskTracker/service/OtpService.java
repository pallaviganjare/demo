package com.taskTracker.service;

import com.taskTracker.model.Otp;
import com.taskTracker.model.User;

public interface OtpService {

	String generateOtp(User user);

	String verifyOtp(Otp otp);


}
