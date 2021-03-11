package com.taskTracker.service;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskTracker.exceptionHandler.ClientSideException;
import com.taskTracker.model.Otp;
import com.taskTracker.model.User;
import com.taskTracker.repository.OtpRepository;
import com.taskTracker.repository.UserRepository;
import com.taskTracker.util.JWTUtil;

@Service
public class OtpServiceImpl implements OtpService{

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OtpRepository otpRepository;
	
	@Override
	public String generateOtp(User user)
	{
		User fetchedUser = userRepository.findByEmailId(user.getEmailId());
		if(fetchedUser==null)
			throw new ClientSideException(401,"Invalid emailId");
		Random random = new Random();
		final int otpNumber=1000+random.nextInt(999);
		if(!ServiceLocator.getEmailService().sendEmail(fetchedUser, otpNumber))
			throw new ClientSideException(500,"Failed to send Email");
		Otp otp=new Otp();
		otp.setOtpNumber(otpNumber);
		otp.setTimeStamp(new Date());
		otp.setEmailId(user.getEmailId());
		otpRepository.deleteOtpByEmailId(otp.getEmailId());
		otpRepository.insert(otp);
		return otp.getEmailId();	
	}
	
	@Override
	public String verifyOtp(Otp otp)
	{
		Otp fetchedOtp = otpRepository.findByEmailId(otp.getEmailId());
		if(fetchedOtp==null)
			throw new ClientSideException(401,"Invalid emailId");
		if((new Date()).getTime()-fetchedOtp.getTimeStamp().getTime()>180000)
			throw new ClientSideException(401,"OTP expired");
		if(fetchedOtp.getOtpNumber()!=otp.getOtpNumber())
			throw new ClientSideException(401,"Invalid OTP");
		User fetchedUser = userRepository.findByEmailId(otp.getEmailId());
		String token=jwtUtil.generateToken(fetchedUser);
		return token;
	}
}
