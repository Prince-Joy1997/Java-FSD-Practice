package com.topjobs.JobSeeker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

import com.topjobs.JobSeeker.exception.ApplicationAlreadyExistsException;
import com.topjobs.JobSeeker.exception.InvalidStatusException;
import com.topjobs.JobSeeker.exception.JobIDDoesNotExistException;
import com.topjobs.JobSeeker.exception.JobSeekerIdAlreadyExistsException;
import com.topjobs.JobSeeker.exception.JobSeekerIdDoesNotExistException;
import com.topjobs.JobSeeker.model.Application;
import com.topjobs.JobSeeker.model.JobSeeker;
import com.topjobs.JobSeeker.repository.JobSeekerRepository;

public class JobSeekerServiceTest {
	@Mock
	JobSeekerRepository jobSeekerRepo;
	
	@InjectMocks
	JobSeekerServiceImpl jobSeekerService;
	
	// variables needed
	 private JobSeeker jS1;
	 private JobSeeker jS2;
	 private List<JobSeeker> jobSeekers;
	 private List<Application> applications;
	
	@BeforeEach
	public void initialize() {
		MockitoAnnotations.initMocks(this);
		// initialize variables needed
		applications = new ArrayList<Application>();
		applications.add(new Application("1", "pending"));
		applications.add(new Application("2", "selected"));
		applications.add(new Application("3", "rejected"));
		jS1 = new JobSeeker("testUsername1", "testFirstName", "testLastName", "testEmail", "testAddress", "testResume",
				6478390218L, applications);
		jS2 = new JobSeeker("testUsername2", "testFirstName2", "testLastName2", "testEmail2", "testAddress2", "testResume2",
				6478390218L, applications);
		jobSeekers = new ArrayList<JobSeeker>();
		jobSeekers.add(jS1);
		jobSeekers.add(jS2);
	}
	
	@AfterEach
	public void tearDown() {
		// make variables needed null
		jS1 = null;
		jS2 = null;
		applications = null;
		jobSeekers = null;
	}
	
	@Test
	public void givenJobSeekerToRegisterThenShouldRegisterJobSeeker () throws JobSeekerIdAlreadyExistsException {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.empty());
		Mockito.when(jobSeekerRepo.save(jS1)).thenReturn(jS1);
		assertEquals(jS1, jobSeekerService.registerJobSeeker(jS1));
	}
	
	@Test
	public void givenDuplicateJobSeekerToRegisterThenShouldThrowException () {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		assertThrows(JobSeekerIdAlreadyExistsException.class, () -> {
			jobSeekerService.registerJobSeeker(jS1);
		});
	}
	
	@Test
	public void shouldReturnJobSeekerList() {
		Mockito.when(jobSeekerRepo.findAll()).thenReturn(jobSeekers);
		assertEquals(jobSeekers, jobSeekerService.viewAllJobSeekers());
	}
	
	@Test
	public void givenJobSeekerIDThenShouldReturnJobSeeker() throws JobSeekerIdDoesNotExistException {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		assertEquals(jS1, jobSeekerService.viewJobSeeker(jS1.getUsername()));
	}
	
	@Test
	public void givenInvalidJobSeekerIDToViewJobSeekerThenShouldThrowException() {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.empty());
		assertThrows(JobSeekerIdDoesNotExistException.class, () -> {
			jobSeekerService.viewJobSeeker(jS1.getUsername());
		});
	}
	
	@Test
	public void givenJobSeekerToUpdateThenShouldReturnUpdatedJobSeeker() throws JobSeekerIdDoesNotExistException {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		Mockito.when(jobSeekerRepo.save(jS1)).thenReturn(jS1);
		assertEquals(jS1, jobSeekerService.updateJobSeeker(jS1));
	}
	
	@Test
	public void givenInvalidJobSeekerToUpdateThenShouldThrowException() {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.empty());
		Mockito.when(jobSeekerRepo.save(jS1)).thenReturn(jS1);
		assertThrows(JobSeekerIdDoesNotExistException.class, () -> {
			jobSeekerService.updateJobSeeker(jS1);
		});
	}
	
	@Test
	public void givenJobSeekerResumeToUpdateThenShouldReturnUpdatedJobSeeker() throws JobSeekerIdDoesNotExistException {
		jS1.setResume("updated resume");
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		Mockito.when(jobSeekerRepo.save(jS1)).thenReturn(jS1);
		assertEquals(jS1, jobSeekerService.updateJobSeekerResume(jS1.getUsername(), "updated resume"));
	}
	
	@Test
	public void givenInvalidJobSeekerResumeToUpdateThenShouldThrowExeption() {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.empty());
		Mockito.when(jobSeekerRepo.save(jS1)).thenReturn(jS1);
		assertThrows(JobSeekerIdDoesNotExistException.class, () -> {
			jobSeekerService.updateJobSeeker(jS1);
		});
	}
	
	@Test
	public void givenJobSeekerIDToDeleteThenShouldReturnTrue() throws JobSeekerIdDoesNotExistException {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		assertEquals(true, jobSeekerService.deleteJobSeeker(jS1.getUsername()));
	}
	
	@Test
	public void givenInvalidJobSeekerIDToDeleteThenShouldThrowExeption() {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.empty());
		assertThrows(JobSeekerIdDoesNotExistException.class, () -> {
			jobSeekerService.deleteJobSeeker(jS1.getUsername());
		});
	}
	
	@Test
	public void givenJobSeekerIDThenShouldReturnAllApplicationsForJobSeeker () throws JobSeekerIdDoesNotExistException {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		assertEquals(applications, jobSeekerService.viewAllApplicationsByJobSeekerId(jS1.getUsername()));
	}
	
	@Test
	public void givenInvalidJobSeekerIDToViewApplicationsThenShouldThrowException() {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.empty());
		assertThrows(JobSeekerIdDoesNotExistException.class, () -> {
			jobSeekerService.viewAllApplicationsByJobSeekerId(jS1.getUsername());
		});
	}
	
	@Test
	public void givenJobIDThenShouldReturnListOfJobSeekersThatContainJobID () {
		Mockito.when(jobSeekerRepo.findAll()).thenReturn(jobSeekers);
		assertEquals(jobSeekers, jobSeekerService.viewAllJobSeekersByJobId("1"));
	}
	
	@Test
	public void givenJobIDToViewJobSeekersByJobIDThenShouldReturnEmptyList () {
		Mockito.when(jobSeekerRepo.findAll()).thenReturn(jobSeekers);
		assertEquals(new ArrayList<JobSeeker>(), jobSeekerService.viewAllJobSeekersByJobId("10"));
	}
	
	@Test
	public void givenJobIDThenShouldReturnListOfSelectedJobSeekersThatContainJobID () {
		Mockito.when(jobSeekerRepo.findAll()).thenReturn(jobSeekers);
		assertEquals(jobSeekers, jobSeekerService.viewAllSelectedJobSeekersByJobId("2"));
	}
	
	@Test
	public void givenJobIDToViewSelectedJobSeekersByJobIDThenShouldReturnEmptyList () {
		Mockito.when(jobSeekerRepo.findAll()).thenReturn(jobSeekers);
		assertEquals(new ArrayList<JobSeeker>(), jobSeekerService.viewAllSelectedJobSeekersByJobId("10"));
	}
	
	@Test
	public void givenJobIDThenShouldReturnListOfRejectedJobSeekersThatContainJobID () {
		Mockito.when(jobSeekerRepo.findAll()).thenReturn(jobSeekers);
		assertEquals(jobSeekers, jobSeekerService.viewAllRejectedJobSeekersByJobId("3"));
	}
	
	@Test
	public void givenJobIDToViewRejectedJobSeekersByJobIDThenShouldReturnEmptyList () {
		Mockito.when(jobSeekerRepo.findAll()).thenReturn(jobSeekers);
		assertEquals(new ArrayList<JobSeeker>(), jobSeekerService.viewAllRejectedJobSeekersByJobId("10"));
	}
	
	@Test
	public void givenApplicationToAddThenShouldAddApplication () throws JobSeekerIdDoesNotExistException, ApplicationAlreadyExistsException, InvalidStatusException {
		JobSeeker jS10 = new JobSeeker("testUsername1", "testFirstName", "testLastName", "testEmail", "testAddress", "testResume",
				6478390218L, applications);
		Application newApp = new Application("5", "pending");
		List<Application> appList = new ArrayList<Application>();
		appList.add(new Application("1", "pending"));
		appList.add(new Application("2", "selected"));
		appList.add(new Application("3", "rejected"));
		appList.add(newApp);
		jS10.setApplicationList(appList);
		
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		Mockito.when(jobSeekerRepo.save(jS10)).thenReturn(jS10);
		assertEquals(newApp, jobSeekerService.addJobSeekerApplication(jS1.getUsername(), newApp));
	}
	
	@Test
	public void givenInvalidStatusApplicationToAddThenShouldThrowException () throws JobSeekerIdDoesNotExistException, ApplicationAlreadyExistsException {
		Application newApp = new Application("5", "invalidstatus");	
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		assertThrows(InvalidStatusException.class, () -> {
			jobSeekerService.addJobSeekerApplication(jS1.getUsername(), newApp);
		});
	}
	
	@Test
	public void givenInvalidJobSeekerIDApplicationToAddThenShouldThrowException () throws InvalidStatusException, ApplicationAlreadyExistsException {
		Application newApp = new Application("5", "pending");	
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.empty());
		assertThrows(JobSeekerIdDoesNotExistException.class, () -> {
			jobSeekerService.addJobSeekerApplication(jS1.getUsername(), newApp);
		});
	}
	
	@Test
	public void givenDuplicateApplicationToAddThenShouldThrowException () throws InvalidStatusException, JobSeekerIdDoesNotExistException {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		assertThrows(ApplicationAlreadyExistsException.class, () -> {
			jobSeekerService.addJobSeekerApplication(jS1.getUsername(), jS1.getApplicationList().get(0));
		});
	}
	
	@Test
	public void givenApplicationToChangeThenShouldChangeApplicationStatus () throws JobSeekerIdDoesNotExistException, JobIDDoesNotExistException, InvalidStatusException {
		JobSeeker jS10 = new JobSeeker("testUsername1", "testFirstName", "testLastName", "testEmail", "testAddress", "testResume",
				6478390218L, applications);
		List<Application> appList = jS10.getApplicationList();
		appList.get(0).setStatus("selected");
		Application updatedApp = appList.get(0);
		jS10.setApplicationList(appList);
		
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		Mockito.when(jobSeekerRepo.save(jS10)).thenReturn(jS10);
		assertEquals(true, jobSeekerService.updateApplicationStatus(jS1.getUsername(), "1", "selected"));
	}
	
	@Test
	public void givenInvalidStatusApplicationToChangeThenShouldThrowException() throws JobSeekerIdDoesNotExistException, JobIDDoesNotExistException {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		assertThrows(InvalidStatusException.class, () -> {
			jobSeekerService.updateApplicationStatus(jS1.getUsername(), "1", "invalidStatus");
		});
	}
	
	@Test
	public void givenInvalidJobSeekerIDApplicationToChangeThenShouldThrowException() throws InvalidStatusException, JobIDDoesNotExistException {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.empty());
		assertThrows(JobSeekerIdDoesNotExistException.class, () -> {
			jobSeekerService.updateApplicationStatus(jS1.getUsername(), "1", "selected");
		});
	}
	
	@Test
	public void givenInvalidJobIDApplicationToChangeThenShouldThrowException() throws InvalidStatusException, JobSeekerIdDoesNotExistException {
		Mockito.when(jobSeekerRepo.findById(jS1.getUsername())).thenReturn(Optional.of(jS1));
		assertThrows(JobIDDoesNotExistException.class, () -> {
			jobSeekerService.updateApplicationStatus(jS1.getUsername(), "10", "selected");
		});
	}
}
