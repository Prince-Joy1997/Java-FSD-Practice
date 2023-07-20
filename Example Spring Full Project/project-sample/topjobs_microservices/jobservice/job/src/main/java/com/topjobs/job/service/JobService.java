package com.topjobs.job.service;

import java.util.List;

import com.topjobs.job.exception.EmployerNotFoundException;
import com.topjobs.job.exception.JobNotFoundException;
import com.topjobs.job.exception.StatusNotFoundException;
import com.topjobs.job.model.Job;

public interface JobService {
	public boolean addJob(Job job);
	
	List<Job> viewJobs();
	
	Job updateJob(Job job, String jobId) throws JobNotFoundException;
	
	public boolean deleteJob(String jobId);
	
	Job getJobById(String jobId) throws JobNotFoundException;
	
	List<Job> getAllJobsByEmployerId(String employerId) throws JobNotFoundException;
	
	String updateJobStatus(String jobId, String status) throws JobNotFoundException, StatusNotFoundException;

}
