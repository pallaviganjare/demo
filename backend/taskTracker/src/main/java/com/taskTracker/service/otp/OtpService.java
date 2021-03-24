package com.taskTracker.service.otp;

import com.taskTracker.model.otp.Otp;
import com.taskTracker.model.user.User;

public interface OtpService {

	String generateOtp(User user);

	String verifyOtp(Otp otp);


}
