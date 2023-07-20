package com.topjobs.job.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topjobs.job.exception.EmployerNotFoundException;
import com.topjobs.job.exception.JobNotFoundException;
import com.topjobs.job.exception.StatusNotFoundException;
import com.topjobs.job.model.Job;
import com.topjobs.job.service.JobService;
@CrossOrigin
@RestController
@RequestMapping("/job")
public class JobController {
	@Autowired
	JobService jobService;

	/*
	 * Method which will add a specific job - OK
	 */

	@PostMapping("/addJob")
	public ResponseEntity<?> addjob(@RequestBody Job job) {
		boolean result = jobService.addJob(job);
		if (result==true) {
			return new ResponseEntity<Boolean>(result, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Error: News Already Exists", HttpStatus.CONFLICT);
		}
	}

	/*
	 * Method which will view all jobs - OK
	 */

	@GetMapping("/viewJobs")
	public ResponseEntity<?> getjobs() {
		List<Job> result = jobService.viewJobs();
		return new ResponseEntity<List>(result, HttpStatus.OK);
	}
	
	/*
	 * Method which will delete a specific job - OK
	 */

	@DeleteMapping("/deleteJob/{jobId}")
	public ResponseEntity<String> deleteJob(@PathVariable("jobId") String jobId) {
		try {
			boolean result = jobService.deleteJob(jobId);

			if (result) {
				return new ResponseEntity<String>("Job Deleted", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Error: Job not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Error: Invalid Id", HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * This method should be used to get a specific job by jobid - ok
	 */

	@GetMapping("/viewJobById/{jobId}")
	public ResponseEntity<?> getJob(@PathVariable("jobId") String jobId) {
		try {
		Job result = jobService.getJobById(jobId);
		
			return new ResponseEntity<Job>(result, HttpStatus.OK);
		} catch (JobNotFoundException e) {
			return new ResponseEntity<String>("Error: Jobs Not Found", HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * This method should be used to get the jobs created by specific employerId - ok
	 * 
	 */

	@GetMapping("/viewAllJobsByEmployerId/{employerId}")
	public ResponseEntity<?> getAllJobs(@PathVariable("employerId") String employerId){
		try {
		List<Job> result = jobService.getAllJobsByEmployerId(employerId);
		
			return new ResponseEntity<List>(result, HttpStatus.OK);
		} catch (JobNotFoundException e) {
			return new ResponseEntity<String>("Error: Jobs Not Found", HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * Method which will update a specific job
	 */

	@PutMapping("/updateJobById/{jobId}")
	public ResponseEntity<?> updateJob(@PathVariable("jobId") String jobId, @RequestBody Job job) {
		try {
			Job result = jobService.updateJob(job, jobId);
			return new ResponseEntity<Job>(result, HttpStatus.OK);

		} catch (JobNotFoundException e) {
			return new ResponseEntity<String>("Error: Invalid Id", HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * This method should be used to update a job
	 * status.
	 */

	@PutMapping("/updateJobStatus/{jobId}/{status}")
	public ResponseEntity<?> updateJobStatus(@PathVariable("jobId") String jobId,
			@PathVariable("status") String status) throws StatusNotFoundException {
		try {
			String result = jobService.updateJobStatus(jobId, status);
			if (result != null) {
				return new ResponseEntity<String>("Job Status Updated", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Could not find the given Username", HttpStatus.NOT_FOUND);
			}

		} catch (JobNotFoundException e) {
			return new ResponseEntity<String>("Error: Job not found", HttpStatus.NOT_FOUND);
		} catch (StatusNotFoundException e) {
			return new ResponseEntity<String>("Error: Status not found", HttpStatus.NOT_FOUND);
		}
	}
	
}