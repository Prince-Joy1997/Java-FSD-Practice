package com.topjobs.JobSeeker.exception;

public class JobIDDoesNotExistException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public JobIDDoesNotExistException(String message) {
	  super(message);
	}
}
