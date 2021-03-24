package com.taskTracker.model.otp;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "otp")
public class Otp {

	
	int otpNumber;
	Date timeStamp;
	String emailId;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getOtpNumber() {
		return otpNumber;
	}
	public void setOtpNumber(int otpNumber) {
		this.otpNumber = otpNumber;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}  
}
