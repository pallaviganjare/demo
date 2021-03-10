package com.taskTracker.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.taskTracker.repository.OtpRepository;

@Component
public class Scheduler {
	
	@Autowired
	OtpRepository otpRepository;
	
	@Scheduled(fixedDelay = 180000)
	public void removeExpiredOtp()
	{
		otpRepository.deleteExpiredOtp();
	}
}
