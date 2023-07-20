package com.topjobs.JobSeeker.controller;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.topjobs.JobSeeker.exception.ApplicationAlreadyExistsException;
import com.topjobs.JobSeeker.exception.InvalidStatusException;
import com.topjobs.JobSeeker.exception.JobIDDoesNotExistException;
import com.topjobs.JobSeeker.exception.JobSeekerIdAlreadyExistsException;
import com.topjobs.JobSeeker.exception.JobSeekerIdDoesNotExistException;
import com.topjobs.JobSeeker.model.Application;
import com.topjobs.JobSeeker.model.JobSeeker;
import com.topjobs.JobSeeker.service.JobSeekerService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class JobSeekerControllerTest {

	@Autowired
	MockMvc mockmvc;
	
	@InjectMocks
	JobSeekerController jobSeekerController;
	
	@MockBean
	JobSeekerService jobSeekerService;
	
	// variables to use
	 private JobSeeker jS1;
	 private JobSeeker jS2;
	 private List<JobSeeker> jobSeekers;
	 private List<Application> applications;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(jobSeekerController).build();
		// set up variables
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
	
	public String convertObjToString(Object obj) throws JsonProcessingException 
	{
		ObjectMapper objectmapper = new ObjectMapper();
		return objectmapper.writeValueAsString(obj);
	}
	
	@Test
	public void givenJobSeekerToRegisterThenShouldReturnCreated () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.registerJobSeeker(any())).thenReturn(jS1);
		mockmvc.perform(MockMvcRequestBuilders.post("/jobSeeker/registerJobSeeker")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenDuplicateJobSeekerToRegisterThenShouldReturnConflict () throws Exception  {
		Mockito.when(jobSeekerService.registerJobSeeker(any())).thenThrow(JobSeekerIdAlreadyExistsException.class);
		mockmvc.perform(MockMvcRequestBuilders.post("/jobSeeker/registerJobSeeker")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isConflict())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenRequestToViewJobSeekerListThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.viewAllJobSeekers()).thenReturn(jobSeekers);
		mockmvc.perform(MockMvcRequestBuilders.get("/jobSeeker/viewAllJobSeekers")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jobSeekers)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenJobSeekerIDThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.viewJobSeeker(any())).thenReturn(jS1);
		mockmvc.perform(MockMvcRequestBuilders.get("/jobSeeker/viewJobSeeker/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidJobSeekerIDToViewJobSeekerThenShouldReturnNotFound () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.viewJobSeeker(any())).thenThrow(JobSeekerIdDoesNotExistException.class);
		mockmvc.perform(MockMvcRequestBuilders.get("/jobSeeker/viewJobSeeker/100")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenJobSeekerToUpdateThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.updateJobSeeker(any())).thenReturn(jS1);
		mockmvc.perform(MockMvcRequestBuilders.put("/jobSeeker/updateJobSeeker")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidJobSeekerToUpdateThenShouldReturnNotFound () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.updateJobSeeker(any())).thenThrow(JobSeekerIdDoesNotExistException.class);
		mockmvc.perform(MockMvcRequestBuilders.put("/jobSeeker/updateJobSeeker")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenJobSeekerResumeToUpdateThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.updateJobSeekerResume(any(), any())).thenReturn(jS1);
		mockmvc.perform(MockMvcRequestBuilders.put("/jobSeeker/updateJobSeekerResume/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidJobSeekerResumeToUpdateThenShouldReturnNotFound () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.updateJobSeekerResume(any(), any())).thenThrow(JobSeekerIdDoesNotExistException.class);
		mockmvc.perform(MockMvcRequestBuilders.put("/jobSeeker/updateJobSeekerResume/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenJobSeekerIDToDeleteThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.deleteJobSeeker(any())).thenReturn(true);
		mockmvc.perform(MockMvcRequestBuilders.delete("/jobSeeker/deleteJobSeeker/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidJobSeekerIDToDeleteThenShouldReturnNotFound () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.deleteJobSeeker(any())).thenThrow(JobSeekerIdDoesNotExistException.class);
		mockmvc.perform(MockMvcRequestBuilders.delete("/jobSeeker/deleteJobSeeker/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenJobSeekerIDToViewApplicationsThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.viewAllApplicationsByJobSeekerId(any())).thenReturn(applications);
		mockmvc.perform(MockMvcRequestBuilders.get("/jobSeeker/viewAllApplicationsByJobSeekerId/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidJobSeekerIDToViewApplicationsThenShouldReturnNotFound () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.viewAllApplicationsByJobSeekerId(any())).thenThrow(JobSeekerIdDoesNotExistException.class);
		mockmvc.perform(MockMvcRequestBuilders.get("/jobSeeker/viewAllApplicationsByJobSeekerId/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenJobIDToViewListOfJobSeekersThatContainJobIDThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.viewAllJobSeekersByJobId(any())).thenReturn(jobSeekers);
		mockmvc.perform(MockMvcRequestBuilders.get("/jobSeeker/viewAllJobSeekersByJobId/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenJobIDToViewListOfSelectedJobSeekersThatContainJobIDThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.viewAllSelectedJobSeekersByJobId(any())).thenReturn(jobSeekers);
		mockmvc.perform(MockMvcRequestBuilders.get("/jobSeeker/viewAllSelectedJobSeekersByJobId/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenJobIDToViewListOfRejectedJobSeekersThatContainJobIDThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.viewAllRejectedJobSeekersByJobId(any())).thenReturn(jobSeekers);
		mockmvc.perform(MockMvcRequestBuilders.get("/jobSeeker/viewAllRejectedJobSeekersByJobId/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenApplicationToAddThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.addJobSeekerApplication(any(), any())).thenReturn(new Application("1", "pending"));
		mockmvc.perform(MockMvcRequestBuilders.post("/jobSeeker/addJobSeekerApplication/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidStatusApplicationToAddThenShouldReturnConflict () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.addJobSeekerApplication(any(), any())).thenThrow(InvalidStatusException.class);
		mockmvc.perform(MockMvcRequestBuilders.post("/jobSeeker/addJobSeekerApplication/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isConflict())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidJobSeekerIDApplicationToAddThenShouldReturnNotFound () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.addJobSeekerApplication(any(), any())).thenThrow(JobSeekerIdDoesNotExistException.class);
		mockmvc.perform(MockMvcRequestBuilders.post("/jobSeeker/addJobSeekerApplication/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenDuplicateApplicationToAddThenShouldReturnConflict () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.addJobSeekerApplication(any(), any())).thenThrow(ApplicationAlreadyExistsException.class);
		mockmvc.perform(MockMvcRequestBuilders.post("/jobSeeker/addJobSeekerApplication/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isConflict())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenApplicationToChangeThenShouldReturnOk () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.updateApplicationStatus(any(), any(), any())).thenReturn(true);
		mockmvc.perform(MockMvcRequestBuilders.put("/jobSeeker/updateApplicationStatus/1/1/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidStatusApplicationToChangeThenShouldReturnConflict () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.updateApplicationStatus(any(), any(), any())).thenThrow(InvalidStatusException.class);
		mockmvc.perform(MockMvcRequestBuilders.put("/jobSeeker/updateApplicationStatus/1/1/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isConflict())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidJobSeekerIDApplicationToChangeThenShouldReturnNotFound () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.updateApplicationStatus(any(), any(), any())).thenThrow(JobSeekerIdDoesNotExistException.class);
		mockmvc.perform(MockMvcRequestBuilders.put("/jobSeeker/updateApplicationStatus/1/1/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidJobIDApplicationToChangeThenShouldReturnNotFound () throws JsonProcessingException, Exception {
		Mockito.when(jobSeekerService.updateApplicationStatus(any(), any(), any())).thenThrow(JobIDDoesNotExistException.class);
		mockmvc.perform(MockMvcRequestBuilders.put("/jobSeeker/updateApplicationStatus/1/1/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToString(jS1)))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}
}
