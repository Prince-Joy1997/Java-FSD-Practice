package com.topjobs.JobSeeker.model;

public class Application {
	// Attributes
	private String jobID, status;

	// Constructors
	public Application(String jobID, String status) {
		this.jobID = jobID;
		this.status = status;
	}

	public Application() {
	}

	// Getters Setters
	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// toString
	@Override
	public String toString() {
		return "Application [jobID=" + jobID + ", status=" + status + "]";
	}
}
