package com.topjobs.JobSeeker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topjobs.JobSeeker.exception.ApplicationAlreadyExistsException;
import com.topjobs.JobSeeker.exception.InvalidStatusException;
import com.topjobs.JobSeeker.exception.JobIDDoesNotExistException;
import com.topjobs.JobSeeker.exception.JobSeekerIdAlreadyExistsException;
import com.topjobs.JobSeeker.exception.JobSeekerIdDoesNotExistException;
import com.topjobs.JobSeeker.model.Application;
import com.topjobs.JobSeeker.model.JobSeeker;
import com.topjobs.JobSeeker.service.JobSeekerService;
@CrossOrigin
@RestController
public class JobSeekerController {
	// Autowire JobSeeker Service
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekerController (JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	// Handler methods
	@PostMapping("/jobSeeker/registerJobSeeker")
	public ResponseEntity<?> registerJobSeeker (@RequestBody JobSeeker jobSeeker) throws JobSeekerIdAlreadyExistsException {
		try {
			JobSeeker jobSeekerAdded = jobSeekerService.registerJobSeeker(jobSeeker);
			return new ResponseEntity<JobSeeker>(jobSeekerAdded, HttpStatus.CREATED);
		}catch (JobSeekerIdAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/jobSeeker/viewAllJobSeekers")
	public ResponseEntity<List<JobSeeker>> viewAllJobSeekers (){
		return new ResponseEntity<List<JobSeeker>>(jobSeekerService.viewAllJobSeekers(), HttpStatus.OK);
	}
		
	@GetMapping("/jobSeeker/viewJobSeeker/{jobSeekerID}")
	public ResponseEntity<?> viewJobSeeker(@PathVariable String jobSeekerID) throws JobSeekerIdDoesNotExistException {
		try {
			JobSeeker jobSeeker = jobSeekerService.viewJobSeeker(jobSeekerID);
			return new ResponseEntity<JobSeeker>(jobSeeker, HttpStatus.OK);
		}catch (JobSeekerIdDoesNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/jobSeeker/updateJobSeeker")
	public ResponseEntity<?> updateJobSeeker (@RequestBody JobSeeker jobSeeker) throws JobSeekerIdDoesNotExistException {
		try {
			JobSeeker jobSeekerUpdated = jobSeekerService.updateJobSeeker(jobSeeker);
			return new ResponseEntity<JobSeeker>(jobSeekerUpdated, HttpStatus.OK);
		}catch (JobSeekerIdDoesNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/jobSeeker/updateJobSeekerResume/{jobSeekerID}")
	public ResponseEntity<?> updateJobSeekerResume(@PathVariable String jobSeekerID, @RequestBody String resume) throws JobSeekerIdDoesNotExistException {
		try {
			JobSeeker jobSeekerUpdated = jobSeekerService.updateJobSeekerResume(jobSeekerID, resume);
			return new ResponseEntity<JobSeeker>(jobSeekerUpdated, HttpStatus.OK);
		}catch (JobSeekerIdDoesNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/jobSeeker/deleteJobSeeker/{jobSeekerID}")
	public ResponseEntity<String> deleteJobSeeker (@PathVariable String jobSeekerID) throws JobSeekerIdDoesNotExistException {
		try {
			jobSeekerService.deleteJobSeeker(jobSeekerID);
			return new ResponseEntity<String>("Job Seeker with given ID was deleted.", HttpStatus.OK);
		}catch (JobSeekerIdDoesNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/jobSeeker/addJobSeekerApplication/{jobSeekerID}")
	public ResponseEntity<?> addJobSeekerApplication (@PathVariable String jobSeekerID, @RequestBody Application application) 
			throws JobSeekerIdDoesNotExistException, ApplicationAlreadyExistsException, InvalidStatusException {
		try {
			Application applicationAdded = jobSeekerService.addJobSeekerApplication(jobSeekerID, application);
			return new ResponseEntity<Application>(applicationAdded, HttpStatus.CREATED);
		}catch (JobSeekerIdDoesNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}catch (ApplicationAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}catch (InvalidStatusException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/jobSeeker/viewAllApplicationsByJobSeekerId/{jobSeekerID}")
	public ResponseEntity<?> viewAllApplicationsByJobSeekerId (@PathVariable String jobSeekerID) throws JobSeekerIdDoesNotExistException{
		try {
			List<Application> applications = jobSeekerService.viewAllApplicationsByJobSeekerId(jobSeekerID);
			return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
		}catch (JobSeekerIdDoesNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/jobSeeker/viewAllJobSeekersByJobId/{jobID}")
	public ResponseEntity<?> viewAllJobSeekersByJobId (@PathVariable String jobID) {
		return new ResponseEntity<List<JobSeeker>>(jobSeekerService.viewAllJobSeekersByJobId(jobID), HttpStatus.OK);
	}
	
	@GetMapping("/jobSeeker/viewAllSelectedJobSeekersByJobId/{jobID}")
	public ResponseEntity<?> viewAllSelectedJobSeekersByJobId (@PathVariable String jobID) {
		return new ResponseEntity<List<JobSeeker>>(jobSeekerService.viewAllSelectedJobSeekersByJobId(jobID), HttpStatus.OK);
	}
	
	@GetMapping("/jobSeeker/viewAllRejectedJobSeekersByJobId/{jobID}")
	public ResponseEntity<?> viewAllRejectedJobSeekersByJobId (@PathVariable String jobID) {
		return new ResponseEntity<List<JobSeeker>>(jobSeekerService.viewAllRejectedJobSeekersByJobId(jobID), HttpStatus.OK);
	}
	
	@PutMapping("/jobSeeker/updateApplicationStatus/{jobSeekerID}/{jobID}/{status}")
	public ResponseEntity<?> updateApplicationStatus (@PathVariable String jobSeekerID, @PathVariable String jobID, @PathVariable String status) 
			throws JobSeekerIdDoesNotExistException, JobIDDoesNotExistException, InvalidStatusException {
		try {
			jobSeekerService.updateApplicationStatus(jobSeekerID, jobID, status);
			return new ResponseEntity<String>("Status updated.", HttpStatus.OK);
		}catch (JobSeekerIdDoesNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}catch (JobIDDoesNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}catch (InvalidStatusException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
}
