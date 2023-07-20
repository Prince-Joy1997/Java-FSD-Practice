package com.topjobs.JobSeeker.exception;

public class JobSeekerIdAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public JobSeekerIdAlreadyExistsException(String message) {
	  super(message);
	}
}
