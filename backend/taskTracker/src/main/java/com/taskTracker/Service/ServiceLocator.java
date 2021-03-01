package com.taskTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLocator {

	private static PublicService publicService;
	private static AdminService adminService;

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
