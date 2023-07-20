package com.topjobs.job.test.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.topjobs.job.controller.JobController;
import com.topjobs.job.exception.JobAlreadyExistException;
import com.topjobs.job.exception.JobNotFoundException;
import com.topjobs.job.model.Job;
import com.topjobs.job.repository.JobRepository;
import com.topjobs.job.service.JobServiceImpl;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class JobControllerTest {
	
	@LocalServerPort
	String randomServerPort;
	
	@Autowired
	private MockMvc mockMvc;
	private Job job1;
	
	@MockBean
	JobServiceImpl jobService;
	
	@InjectMocks
	private JobController jobController;
	private List<Job> jobList = null;


	@BeforeEach
	public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        
        job1 = new Job();
        job1.setJobId("11");
        job1.setEmployerId("22");
        job1.setTitle("Developer");
        job1.setLocation("Toronto");
        job1.setDescription("Back End");
        job1.setStatus("open");
        job1.setPostedDate(LocalDateTime.now());
        
        jobList= new ArrayList<>();
	}
        
        @AfterEach
    	public void tearDown() {
    		job1 = null;
    	}
        
        
        public static String JsonString(final Object obj) {
        	try {
        	ObjectMapper objmapper = new ObjectMapper();
        	objmapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        	objmapper.registerModule(new JavaTimeModule());
        	return objmapper.writeValueAsString(obj);

        	} catch (Exception e) {
        	throw new RuntimeException(e);
        	}
        	}

//        @Test
//    	public void addJobSucess() throws Exception {
//        	when(jobService.addJob(job1)).thenReturn(true);
//            mockMvc.perform(post("/job/addJob")
//            		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
//                    .contentType(MediaType.APPLICATION_JSON).content(JsonString(job1)))
//                    .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//    	}

    	
//    	@Test
//       	public void addJobFailure() throws Exception {
//            when(jobService.addJob(any())).thenThrow(JobAlreadyExistException.class);
//            mockMvc.perform(post("/addJob")
//            		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
//                    .contentType(MediaType.APPLICATION_JSON).content(JsonString(job1)))
//                    .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
//        }

        
        
        @Test
        public void viewAllJobsSuccess() throws Exception {
            when(jobService.viewJobs()).thenReturn(jobList);
            mockMvc.perform(MockMvcRequestBuilders.get("/job/viewJobs")
            		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
    	 }
    	
//    	@Test
//        public void viewAllJobsFailure() throws Exception {
//            when(jobService.viewJobs()).thenReturn(null);
//            mockMvc.perform(MockMvcRequestBuilders.get("/job/viewJobs")
//            		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
//                    .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(MockMvcResultMatchers.status().isNotFound())
//                    .andDo(MockMvcResultHandlers.print());
//    	 }
//    	
//    	@Test
//        public void deleteJobSuccess() throws Exception {
//            when(jobService.deleteJob("11")).thenReturn(true);
//            mockMvc.perform(delete("/job/deleteJob/11")
//            		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
//                    .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andDo(MockMvcResultHandlers.print());
//
//        }
    	
//    	@Test
//        public void deleteJobFail() throws Exception {
//            when(jobService.deleteJob("11")).thenThrow(JobNotFoundException.class);
//            mockMvc.perform(delete("/job/deleteJob/11")
//            		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
//                    .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isNotFound())
//                    .andDo(MockMvcResultHandlers.print());
//        }
    	
    	@Test
        public void updateJobSuccess() throws Exception {
    		job1.setLocation("Toronto");
            when(jobService.updateJob(any(),eq(job1.getJobId()))).thenReturn(job1);
            mockMvc.perform(put("/job/updateJobById/T11")
            		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                    .contentType(MediaType.APPLICATION_JSON).content(JsonString(job1)))
                    .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        }
    	
    	@Test
        public void updateEmployerFailure() throws Exception {
    		job1.setLocation("Toronto");
            when(jobService.updateJob(any(),eq(job1.getJobId()))).thenThrow(JobNotFoundException.class);
            mockMvc.perform(put("/job/updateJobById/11")
            		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                    .contentType(MediaType.APPLICATION_JSON).content(JsonString(job1)))
                    .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
        }
    	
    	

}
