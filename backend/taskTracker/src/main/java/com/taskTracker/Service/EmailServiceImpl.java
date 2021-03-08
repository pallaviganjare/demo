package com.taskTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.taskTracker.Model.User;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public boolean sendEmail(User user,int otpNumber)
	{
		SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
		//simpleMailMessage.setTo(user.getEmailId());
		simpleMailMessage.setTo("agarwalhimanshu105@gmail.com");
		simpleMailMessage.setText("Your OTP : "+otpNumber);
		//javaMailSender.send(simpleMailMessage);
		return true;
	}
}
