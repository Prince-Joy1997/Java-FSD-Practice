package com.topjobs.JobSeeker.exception;

public class ApplicationAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ApplicationAlreadyExistsException(String message) {
	  super(message);
	}
}
