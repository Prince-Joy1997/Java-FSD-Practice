package com.topjobs.job.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topjobs.job.exception.EmployerNotFoundException;
import com.topjobs.job.exception.JobNotFoundException;
import com.topjobs.job.exception.StatusNotFoundException;
import com.topjobs.job.model.Job;
import com.topjobs.job.repository.JobRepository;


@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	JobRepository jobRepo;
	
	
	/*
	 * This method should be used to add a new job.
	 */

	@Override
	public boolean addJob(Job job) {
		
		job.setPostedDate(LocalDateTime.now());
		
		Optional<Job> savejobs = jobRepo.findById(job.getJobId());
		
		if (savejobs.isEmpty()) {
			jobRepo.insert(job);
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * This method should be used to view all jobs.
	 */
	@Override
	public List<Job> viewJobs() {
		return jobRepo.findAll();
	}
	
	/*
	 * This method should be used to update an existing job.
	 */
	
	@Override
	public Job updateJob(Job job, String jobId) throws JobNotFoundException {
		Optional<Job> updatejobs = jobRepo.findById(jobId);
		try {
			if (updatejobs.isEmpty())
				throw new JobNotFoundException("Error: Job Not Found");
			else {
				Job jobs = updatejobs.get();
				jobs = job;
				jobRepo.save(jobs);
				return job;
			}
				
			//return job;

		} catch (NoSuchElementException e) {
			throw new JobNotFoundException("Error: Job Not Found");
		}
	}
	
	/*
	 * This method should be used to update a job status.
	 */
	
	@Override
	public String updateJobStatus(String jobId, String status) throws JobNotFoundException, StatusNotFoundException {
		if (status.equals("open") || status.equals("closed")){
			
		Optional<Job> updatejobs = jobRepo.findById(jobId);
		
			if (updatejobs.isPresent()) {
				Job job = updatejobs.get();
				job.setStatus(status);
				jobRepo.save(job);
				return status;
			}
			else {
				throw new JobNotFoundException("Error: Job Not Found");
			}	
		}else {
			throw new StatusNotFoundException("Error: Status Not Found");
		}
		
	}
	
	/*
	 * This method should be used to delete an existing job.
	 */
	
	@Override
	public boolean deleteJob(String jobId) {
		Optional<Job> deletejobs = jobRepo.findById(jobId);
		if (deletejobs != null) {
			jobRepo.deleteById(jobId);
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * This method should be used to get the jobs created by specific employerId
	 */
	
	@Override
	public List<Job> getAllJobsByEmployerId(String employerId) throws JobNotFoundException{
			try {
				return jobRepo.findAllJobByEmployerId(employerId);
				
			} catch (NoSuchElementException e) {
				return null;
			}
		}
	
	/*
	 * This method should be used to get a specific job by jobid
	 */
	
	 @Override
	    public Job getJobById(String jobId) throws JobNotFoundException {
	    	Optional<Job> obj = jobRepo.findById(jobId);
	    	if(obj.isPresent()) {
	    		
	    		return obj.get();
	    	}
	    	else {
	    		throw new JobNotFoundException("Job ID does not exist");
	    	}
	    }
	
	}


