package com.topjobs.job.exception;

public class JobAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public JobAlreadyExistException(String message) {
		super(message);
	}

}
