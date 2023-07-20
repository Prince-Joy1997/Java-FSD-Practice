package com.topjobs.JobSeeker.exception;

public class JobSeekerIdDoesNotExistException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public JobSeekerIdDoesNotExistException(String message) {
	  super(message);
	}
}
