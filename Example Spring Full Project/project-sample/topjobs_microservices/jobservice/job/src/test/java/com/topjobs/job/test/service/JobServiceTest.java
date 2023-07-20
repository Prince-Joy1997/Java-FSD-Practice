package com.topjobs.job.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.topjobs.job.exception.JobNotFoundException;
import com.topjobs.job.model.Job;
import com.topjobs.job.repository.JobRepository;
import com.topjobs.job.service.JobServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

public class JobServiceTest {
	
	@Mock
	JobRepository jobRepo;
	
	@InjectMocks
	JobServiceImpl jobService;
	
	 private Job job1;
	 private Job job2;
	 private List<Job> jobList;
	 
	 Optional<Job> options;
	 
	
	@BeforeEach
	public void initialize() {
		
		// initialize variables 
		MockitoAnnotations.initMocks(this);
		
		job1 = new Job();
        job1.setJobId("11");
        job1.setEmployerId("22");
        job1.setTitle("Developer");
        job1.setLocation("Toronto");
        job1.setDescription("Back End");
        job1.setStatus("open");
        //job1.setPostedDate();
        
        job2 = new Job();
        job2.setJobId("12");
        job2.setEmployerId("23");
        job2.setTitle("Developer 2");
        job2.setLocation("Montreal");
        job2.setDescription("Front End");
        job2.setStatus("closed");
        //job2.setPostedDate();
		
		jobList = new ArrayList<Job>();
		jobList.add(job1);
		jobList.add(job2);
	}
	
	@AfterEach
	public void tearDown() {
		// make variables needed null
		job1 = null;
		job2 = null;
	}
	
	@Test
	public void addJobSucess () {
		Mockito.when(jobRepo.insert((Job) any())).thenReturn(job1);
		boolean status = jobService.addJob(job1);
		assertEquals(true, status);
	}
	
	@Test
    public void addNewsFailure(){

        Mockito.when(jobRepo.findById(job1.getJobId())).thenReturn(Optional.of(job1));
        boolean status = jobService.addJob(job1);
        assertEquals(false, status);
     }
	
	@Test
	public void returnJobListSucess() {
		Mockito.when(jobRepo.findAll()).thenReturn(jobList);
		assertEquals(jobList, jobService.viewJobs());			
	}
	
	@Test
	public void deleteJobSucess(){
		Mockito.when(jobRepo.findById(job1.getJobId())).thenReturn(Optional.of(job1));
		assertEquals(true, jobService.deleteJob(job1.getJobId()));
	}
	
//	@Test
//    public void deleteJobFailure() throws JobNotFoundException {
//    	  Mockito.when(jobRepo.findById(job1.getJobId())).thenReturn(Optional.empty());
//    	  assertThrows(
//        		JobNotFoundException.class,
//                    () -> { jobService.deleteJob("11"); });
//    }
	
	@Test
    public void viewJobByIdSuccess() throws JobNotFoundException {
        Mockito.when(jobRepo.findById("11")).thenReturn(Optional.of(job1));
        Job fetechedJob = jobService.getJobById("11");
        assertEquals(job1, fetechedJob);
    }
	
    @Test
    public void viewJobByIdFailure() throws JobNotFoundException {
        Mockito.when(jobRepo.findById("14")).thenReturn(Optional.empty());
        
        assertThrows(
        		JobNotFoundException.class,
                    () -> { jobService.getJobById("TestUser"); });       
    }
    
//    @Test
//    public void updateEmployerSuccess() throws JobNotFoundException {
//        Mockito.when(jobRepo.findById(job1.getEmployerId())).thenReturn(Optional.of(job1));
//        job1.setLocation("Montreal");
//        Job fetchedemp = jobService.updateJob(job1, job1.getJobId());
//        assertEquals(job1, fetchedemp);
//    }
    
    @Test
    public void updateJobFailure() throws JobNotFoundException {

        Mockito.when(jobRepo.findById("11")).thenReturn(Optional.empty());
        job1.setLocation("Montreal");
      
        assertThrows(
        		JobNotFoundException.class,
                    () -> { jobService.updateJob(job1, job1.getJobId()); });
    }

	}
	
	


