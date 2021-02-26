package com.taskTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLocator {

	private static PublicService publicService;

	public static PublicService getPublicService() {
		return publicService;
	}

	@Autowired
	public void setPublicService(PublicService publicService) {
		ServiceLocator.publicService = publicService;
	}
}
