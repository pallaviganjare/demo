package com.taskTracker.service.email;

import com.taskTracker.model.user.User;

public interface EmailService {

	boolean sendEmail(User user,int otpNumber);

}
