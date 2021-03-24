package com.taskTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taskTracker.service.admin.AdminService;
import com.taskTracker.service.email.EmailService;
import com.taskTracker.service.otp.OtpService;
import com.taskTracker.service.publicService.PublicService;

@Component
public class ServiceLocator {

	private static PublicService publicService;
	private static AdminService adminService;
	private static OtpService otpService;
	private static EmailService emailService;

	public static EmailService getEmailService() {
		return emailService;
	}

	@Autowired
	public void setEmailService(EmailService emailService) {
		ServiceLocator.emailService = emailService;
	}

	public static OtpService getOtpService() {
		return otpService;
	}

	@Autowired
	public void setOtpService(OtpService otpService) {
		ServiceLocator.otpService = otpService;
	}

	public static AdminService getAdminService() {
		return adminService;
	}

	@Autowired
	public void setAdminService(AdminService adminService) {
		ServiceLocator.adminService = adminService;
	}

	public static PublicService getPublicService() {
		return publicService;
	}

	@Autowired
	public void setPublicService(PublicService publicService) {
		ServiceLocator.publicService = publicService;
	}
}
