package com.taskTracker.Service;

import com.taskTracker.Model.User;

public interface EmailService {

	boolean sendEmail(User user,int otpNumber);

}
