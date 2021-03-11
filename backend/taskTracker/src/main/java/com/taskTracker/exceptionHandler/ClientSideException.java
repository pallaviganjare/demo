package com.taskTracker.exceptionHandler;

public class ClientSideException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Integer resourceId;

	public ClientSideException(Integer resourceId, String message) {
		super(message);
		this.setResourceId(resourceId);
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
}
