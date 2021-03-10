package com.taskTracker.service;

import com.taskTracker.model.User;

public interface EmailService {

	boolean sendEmail(User user,int otpNumber);

}
