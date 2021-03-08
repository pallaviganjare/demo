package com.taskTracker.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taskTracker.Config.JWTUtil;
import com.taskTracker.Model.Otp;
import com.taskTracker.Model.User;
import com.taskTracker.repository.OtpRepository;
import com.taskTracker.repository.UserRepository;

@Service
public class OtpServiceImpl implements OtpService{

	@Autowired
	private JWTUtil jwtUtil;
	
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
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message","Failed to send Email"));
		Otp otp=new Otp();
		otp.setOtpNumber(otpNumber);
		otp.setTimeStamp(new Date());
		otp.setEmailId(user.getEmailId());
		otpRepository.deleteOtpByEmailId(otp.getEmailId());
		otpRepository.insert(otp);
		return ResponseEntity.ok().body(Map.of("emailId",fetchedUser.getEmailId()));	
	}
	
	@Override
	public ResponseEntity<Object> verifyOtp(Otp otp)
	{
		Otp fetchedOtp = otpRepository.findByEmailId(otp.getEmailId());
		if(fetchedOtp==null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","Invalid emailId"));
		if(fetchedOtp.getTimeStamp().getTime()-(new Date()).getTime()>180000)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","Otp expired"));
		if(fetchedOtp.getOtpNumber()!=otp.getOtpNumber())
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","Invalid Otp"));
		User fetchedUser = userRepository.findByEmailId(otp.getEmailId());
		String token=jwtUtil.generateToken(fetchedUser);
		return ResponseEntity.ok().body(Map.of("token", token));
	}
}
