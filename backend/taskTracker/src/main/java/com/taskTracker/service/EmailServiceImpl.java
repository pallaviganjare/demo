package com.taskTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.taskTracker.model.User;

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
		simpleMailMessage.setSubject("Task Tracker OTP");
		simpleMailMessage.setText("Your OTP for Task Tracker : "+otpNumber);
		javaMailSender.send(simpleMailMessage);
		return true;
	}
}
