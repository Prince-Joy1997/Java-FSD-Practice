package com.topjobs.JobSeeker.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topjobs.JobSeeker.exception.ApplicationAlreadyExistsException;
import com.topjobs.JobSeeker.exception.InvalidStatusException;
import com.topjobs.JobSeeker.exception.JobIDDoesNotExistException;
import com.topjobs.JobSeeker.exception.JobSeekerIdAlreadyExistsException;
import com.topjobs.JobSeeker.exception.JobSeekerIdDoesNotExistException;
import com.topjobs.JobSeeker.model.Application;
import com.topjobs.JobSeeker.model.JobSeeker;
import com.topjobs.JobSeeker.repository.JobSeekerRepository;

@Service
public class JobSeekerServiceImpl implements JobSeekerService{
	// Autowire Repo
	private JobSeekerRepository jobSeekerRepo;
	
	@Autowired
	public JobSeekerServiceImpl (JobSeekerRepository jobSeekerRepo) {
		this.jobSeekerRepo = jobSeekerRepo;
	}
		
	@Override
	public JobSeeker registerJobSeeker(JobSeeker jobSeeker) throws JobSeekerIdAlreadyExistsException {
		
		Optional<JobSeeker> jobSeekerCheck = jobSeekerRepo.findById(jobSeeker.getUsername());
		
		if (jobSeekerCheck.isEmpty()) {
			return jobSeekerRepo.save(jobSeeker);
		}else {
			throw new JobSeekerIdAlreadyExistsException("The specified job seeker ID already exists.");
		}
	}

	@Override
	public List<JobSeeker> viewAllJobSeekers() {
		return jobSeekerRepo.findAll();
	}

	@Override
	public JobSeeker viewJobSeeker(String jobSeekerID) throws JobSeekerIdDoesNotExistException {
		Optional<JobSeeker> jobSeekerCheck = jobSeekerRepo.findById(jobSeekerID);
		
		if (jobSeekerCheck.isPresent()) {
			return jobSeekerCheck.get();
		}else {
			throw new JobSeekerIdDoesNotExistException("There was no job seeker found with the specified job seeker ID.");
		}
	}

	@Override
	public JobSeeker updateJobSeeker(JobSeeker jobSeeker) throws JobSeekerIdDoesNotExistException {
		Optional<JobSeeker> jobSeekerCheck = jobSeekerRepo.findById(jobSeeker.getUsername());
		
		if (jobSeekerCheck.isPresent()) {
			return jobSeekerRepo.save(jobSeeker);
		}else {
			throw new JobSeekerIdDoesNotExistException("There was no job seeker found with the specified job seeker ID.");
		}
	}

	@Override
	public JobSeeker updateJobSeekerResume(String jobSeekerID, String resume) throws JobSeekerIdDoesNotExistException {
		Optional<JobSeeker> jobSeekerCheck = jobSeekerRepo.findById(jobSeekerID);
		
		if (jobSeekerCheck.isPresent()) {
			JobSeeker jobSeeker = jobSeekerCheck.get();
			jobSeeker.setResume(resume);
			return jobSeekerRepo.save(jobSeeker);
		}else {
			throw new JobSeekerIdDoesNotExistException("There was no job seeker found with the specified job seeker ID.");
		}
	}

	@Override
	public Boolean deleteJobSeeker(String jobSeekerID) throws JobSeekerIdDoesNotExistException {
		Optional<JobSeeker> jobSeekerCheck = jobSeekerRepo.findById(jobSeekerID);
		
		if (jobSeekerCheck.isPresent()) {
			jobSeekerRepo.deleteById(jobSeekerID);
			return true;
		}else {
			throw new JobSeekerIdDoesNotExistException("There was no job seeker found with the specified job seeker ID.");
		}
	}

	@Override
	public List<Application> viewAllApplicationsByJobSeekerId(String jobSeekerID) throws JobSeekerIdDoesNotExistException {
		Optional<JobSeeker> jobSeekerCheck = jobSeekerRepo.findById(jobSeekerID);
		
		if (jobSeekerCheck.isPresent()) {
			return jobSeekerCheck.get().getApplicationList();
		}else {
			throw new JobSeekerIdDoesNotExistException("There was no job seeker found with the specified job seeker ID.");
		}
	}

	@Override
	public List<JobSeeker> viewAllJobSeekersByJobId(String jobID) {
		List<JobSeeker> jobSeekers = jobSeekerRepo.findAll();
		List<JobSeeker> result = jobSeekers.stream()
			.filter(jS -> jS.getApplicationList().stream().filter(a -> a.getJobID().equals(jobID)).findFirst().isPresent())
			.collect(Collectors.toList());
		return result;
	}

	@Override
	public List<JobSeeker> viewAllSelectedJobSeekersByJobId(String jobID) {
		List<JobSeeker> jobSeekers = jobSeekerRepo.findAll();
		List<JobSeeker> result = jobSeekers.stream()
			.filter(jS -> jS.getApplicationList()
							 .stream()
							 .filter(a -> a.getJobID().equals(jobID) && a.getStatus().equals("selected"))
							 .findFirst()
							 .isPresent())
			.collect(Collectors.toList());
		return result;
	}

	@Override
	public List<JobSeeker> viewAllRejectedJobSeekersByJobId(String jobID) {
		List<JobSeeker> jobSeekers = jobSeekerRepo.findAll();
		List<JobSeeker> result = jobSeekers.stream()
			.filter(jS -> jS.getApplicationList()
							.stream()
							.filter(a -> a.getJobID().equals(jobID) && a.getStatus().equals("rejected"))
							.findFirst()
							.isPresent())
			.collect(Collectors.toList());
		return result;
	}

	@Override
	public Boolean updateApplicationStatus(String jobSeekerID, String jobID, String status) 
			throws JobSeekerIdDoesNotExistException, JobIDDoesNotExistException, InvalidStatusException {
		
		if (status.equals("selected") || status.equals("rejected")) {
			Optional<JobSeeker> jobSeekerCheck = jobSeekerRepo.findById(jobSeekerID);
			
			if (jobSeekerCheck.isPresent()) {
				JobSeeker jobSeeker = jobSeekerCheck.get();
				List<Application> applications = jobSeeker.getApplicationList();
				Boolean jobApplicationExists = applications.stream().anyMatch(a -> a.getJobID().equals(jobID));
				
				if(jobApplicationExists) {
					applications.forEach(a -> {
						if (a.getJobID().equals(jobID)) {
							a.setStatus(status);
						}
					});
					
					jobSeeker.setApplicationList(applications);
					jobSeekerRepo.save(jobSeeker);
					return true;
				}else {
					throw new JobIDDoesNotExistException("Job ID does not exist for specified job seeker.");
				}
			}else {
				throw new JobSeekerIdDoesNotExistException("There was no job seeker found with the specified job seeker ID.");
			}
		}else {
			throw new InvalidStatusException("Specified status is invalid, valid statuses include selected and rejected.");
		}
	}

	@Override
	public Application addJobSeekerApplication(String jobSeekerID, Application application)
			throws JobSeekerIdDoesNotExistException, ApplicationAlreadyExistsException, InvalidStatusException {
		
		if (application.getStatus().equals("pending") || application.getStatus().equals("selected") || application.getStatus().equals("rejected")) {
			Optional<JobSeeker> jobSeekerCheck = jobSeekerRepo.findById(jobSeekerID);
			
			if (jobSeekerCheck.isPresent()) {
				JobSeeker jobSeeker = jobSeekerCheck.get();
				List<Application> applications = jobSeeker.getApplicationList();
				Boolean applicationExists = applications.stream().anyMatch(a -> a.getJobID().equals(application.getJobID()));
				
				if (applicationExists) {
					throw new ApplicationAlreadyExistsException("Application already exists.");
				}else {
					applications.add(application);
					jobSeeker.setApplicationList(applications);
					jobSeekerRepo.save(jobSeeker);
					return application;
				}
			}else {
				throw new JobSeekerIdDoesNotExistException("There was no job seeker found with the specified job seeker ID.");
			}
		}else {
			throw new InvalidStatusException("Specified status is invalid, valid statuses include pending, selected and rejected.");
		}
	}

}
