package com.topjobs.job.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document
public class Job {
	
	@Id
		private String jobId;
		private String employerId;
		private String title;
		private String location;
		private String description;
		private String status;
		
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime postedDate;
	
	
	public Job(){}


	public Job(String jobId, String employerId, String title, String location, String description, String status,
			LocalDateTime postedDate) {
		super();
		this.jobId = jobId;
		this.employerId = employerId;
		this.title = title;
		this.location = location;
		this.description = description;
		this.status = status;
		this.postedDate = postedDate;
	}


	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public String getEmployerId() {
		return employerId;
	}


	public void setEmployerId(String employerId) {
		this.employerId = employerId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDateTime getPostedDate() {
		return postedDate;
	}


	public void setPostedDate(LocalDateTime postedDate) {
		this.postedDate = postedDate;
	}


	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", employerId=" + employerId + ", title=" + title + ", location=" + location
				+ ", description=" + description + ", status=" + status + ", postedDate=" + postedDate + "]";
	};
}
	

