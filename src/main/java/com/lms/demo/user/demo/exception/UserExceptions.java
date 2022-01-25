package com.lms.demo.user.demo.exception;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author shital
 * This is User defined Exception class.
 *
 */
public class UserExceptions extends Exception {
	
	private static final long serialVersionUID = 1L;
	private Date timeStamp;
	private String message;
	private String details;	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public UserExceptions(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	public UserExceptions(LocalDateTime now, String skill_name, String details2) {
		// TODO Auto-generated constructor stub
	}

}
