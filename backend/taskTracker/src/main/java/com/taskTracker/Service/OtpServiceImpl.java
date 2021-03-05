package com.taskTracker.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taskTracker.Model.Otp;
import com.taskTracker.Model.User;
import com.taskTracker.repository.OtpRepository;
import com.taskTracker.repository.UserRepository;

@Service
public class OtpServiceImpl implements OtpService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OtpRepository otpRepository;
	
	@Override
	public ResponseEntity<Object> generateOtp(User user)
	{
		User fetchedUser = userRepository.findByEmailId(user.getEmailId());
		if(fetchedUser==null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","Invalid emailId"));
		Random random = new Random();
		final int otpNumber=1000+random.nextInt(999);
		if(!ServiceLocator.getEmailService().sendEmail(fetchedUser, otpNumber))
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message","Email Error"));
		Otp otp=new Otp();
		otp.setOtpNumber(otpNumber);
		otp.setTimeStamp(new Date());
		otp.setEmailId(user.getEmailId());
		otpRepository.insert(otp);
		return ResponseEntity.ok().body(Map.of("emailId",fetchedUser.getEmailId()));	
	}
	
	@Override
	public ResponseEntity<Object> verifyOtp(User user)
	{
		return null;
	}
}