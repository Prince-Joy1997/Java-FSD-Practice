package com.topjobs.JobSeeker.service;

import java.util.List;

import com.topjobs.JobSeeker.exception.ApplicationAlreadyExistsException;
import com.topjobs.JobSeeker.exception.InvalidStatusException;
import com.topjobs.JobSeeker.exception.JobIDDoesNotExistException;
import com.topjobs.JobSeeker.exception.JobSeekerIdAlreadyExistsException;
import com.topjobs.JobSeeker.exception.JobSeekerIdDoesNotExistException;
import com.topjobs.JobSeeker.model.Application;
import com.topjobs.JobSeeker.model.JobSeeker;

public interface JobSeekerService {
	public JobSeeker registerJobSeeker (JobSeeker jobSeeker) throws JobSeekerIdAlreadyExistsException;
	public List<JobSeeker> viewAllJobSeekers ();
	public JobSeeker viewJobSeeker (String jobSeekerID) throws JobSeekerIdDoesNotExistException;
	public JobSeeker updateJobSeeker (JobSeeker jobSeeker) throws JobSeekerIdDoesNotExistException;
	public JobSeeker updateJobSeekerResume (String jobSeekerID, String resume) throws JobSeekerIdDoesNotExistException;
	public Boolean deleteJobSeeker (String jobSeekerID) throws JobSeekerIdDoesNotExistException;
	public Application addJobSeekerApplication (String jobSeekerID, Application application) 
			throws JobSeekerIdDoesNotExistException, ApplicationAlreadyExistsException, InvalidStatusException;
	public List<Application> viewAllApplicationsByJobSeekerId (String jobSeekerID) throws JobSeekerIdDoesNotExistException;
	public List<JobSeeker> viewAllJobSeekersByJobId (String jobID);
	public List<JobSeeker> viewAllSelectedJobSeekersByJobId (String jobID);
	public List<JobSeeker> viewAllRejectedJobSeekersByJobId (String jobID);
	public Boolean updateApplicationStatus (String jobSeekerID, String jobID, String status) 
			throws JobSeekerIdDoesNotExistException, JobIDDoesNotExistException, InvalidStatusException;
}
