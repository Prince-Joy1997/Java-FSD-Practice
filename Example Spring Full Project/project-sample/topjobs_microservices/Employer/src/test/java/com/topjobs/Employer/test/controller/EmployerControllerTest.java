package com.topjobs.Employer.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.topjobs.Employer.controller.EmployerController;
import com.topjobs.Employer.exception.EmployerAlreadyExistException;
import com.topjobs.Employer.exception.EmployerNotFoundException;
import com.topjobs.Employer.model.Employer;
import com.topjobs.Employer.service.EmployerService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class EmployerControllerTest {
		
	@LocalServerPort
	String randomServerPort;
		
	@Autowired
	private MockMvc mockMvc;
	private Employer employer;
	
	@MockBean
	private EmployerService service;
	
	@InjectMocks
	private EmployerController empcontroller;
	private List<Employer> employerlist = null;
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		employer = new Employer();
		employer.setUsername("TestUser");
		employer.setFirstname("TestFirstname");
		employer.setLastname("TestLastname");
		employer.setEmail("Test@gmail.com");
		employer.setCompanyName("CGI");
		employer.setPhoneNumber(989824010);
		employer.setAccountStatus(false);
		
		employerlist = new ArrayList<>();
		employerlist.add(employer);
	//	options = Optional.of(employer);
	}
	
	@Test
   	public void registerEmployerSuccess() throws Exception {

        when(service.registerEmployer(employer)).thenReturn(employer);
        mockMvc.perform(post("/employer/registerEmployer")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(employer)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

    }
	
	@Test
   	public void registerEmployerFailure() throws Exception {

        when(service.registerEmployer(any())).thenThrow(EmployerAlreadyExistException.class);
        mockMvc.perform(post("/employer/registerEmployer")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(employer)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
    }
	
	@Test
    public void viewAllEmployerSuccess() throws Exception {
        when(service.viewAllEmployer()).thenReturn(employerlist);
        mockMvc.perform(MockMvcRequestBuilders.get("/employer/viewAllEmployer")
        		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
	 }
	
	@Test
    public void viewAllEmployerFailure() throws Exception {
        when(service.viewAllEmployer()).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/employer/viewAllEmployer")
        		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
	 }
	
	@Test
    public void updateEmployerSuccess() throws Exception {
		employer.setCompanyName("Google");
        when(service.updateEmployer(any(),eq(employer.getUsername()))).thenReturn(employer);
        mockMvc.perform(put("/employer/updateEmployer/TestUser")
        		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(employer)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

    }
	
	@Test
    public void updateEmployerFailure() throws Exception {
		employer.setCompanyName("Google");
        when(service.updateEmployer(any(),eq(employer.getUsername()))).thenThrow(EmployerNotFoundException.class);
        mockMvc.perform(put("/employer/updateEmployer/TestUser")
        		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(employer)))
                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());

    }
	
	@Test
    public void updateaccountStatusSuccess() throws Exception {
		employer.setAccountStatus(true);
        when(service.updateAccountStatus(eq(employer.getUsername()), eq(true))).thenReturn(true);
        mockMvc.perform(put("/employer/updateAccountStatus/TestUser/true")
        		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(employer)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }
	
	@Test
    public void updateaccountStatusFailure() throws Exception {
		employer.setAccountStatus(true);
        when(service.updateAccountStatus(eq(employer.getUsername()), eq(true))).thenThrow(EmployerNotFoundException.class);
        mockMvc.perform(put("/employer/updateAccountStatus/TestUser/true")
        		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(employer)))
                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
    }
	
	@Test
    public void deleteEmployerSuccess() throws Exception {
        when(service.deleteEmployerById("TestUser")).thenReturn(true);
        mockMvc.perform(delete("/employer/deleteEmployer/TestUser")
        		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
	
	@Test
    public void deleteEmployerFail() throws Exception {
        when(service.deleteEmployerById("TestUser")).thenThrow(EmployerNotFoundException.class);
        mockMvc.perform(delete("/employer/deleteEmployer/TestUser")
        		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());

    }

	@Test
    public void viewAllEmployerByStatysSuccess() throws Exception {
        when(service.viewEmployerByStatus(false)).thenReturn(employerlist);
        mockMvc.perform(MockMvcRequestBuilders.get("/employer/viewEmployerBystatus/false")
        		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
	 }
	    
	@Test
	public void viewAllEmployerByStatysFailure() throws Exception {
	    when(service.viewEmployerByStatus(false)).thenReturn(null);
	    mockMvc.perform(MockMvcRequestBuilders.get("/employer/viewEmployerBystatus/false")
	    		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(MockMvcResultMatchers.status().isNotFound())
	            .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void getEmployersBystatusSuccess() throws Exception {
	    when(service.viewEmployerByStatus(employer.isAccountStatus())).thenReturn(employerlist);
	    mockMvc.perform(MockMvcRequestBuilders.get("/employer/viewEmployerBystatus/false")
	    		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getEmployersBystatusFailure() throws Exception {
	    when(service.viewEmployerByStatus(employer.isAccountStatus())).thenReturn(null);
	    mockMvc.perform(MockMvcRequestBuilders.get("/employer/viewEmployerBystatus/false")
	    		.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbndhcmtoYW4iLCJpYXQiOjE2NDk0MzYyMDB9.j-rd-DyeFKB9jeke6ok7WFOeo8Uts6fkoFQ16tyQFwg")
                .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	
	public static String asJsonString(final Object obj) {
		try {
			ObjectMapper objmapper = new ObjectMapper();
			objmapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objmapper.registerModule(new JavaTimeModule());
		    return objmapper.writeValueAsString(obj);
		    
		} catch (Exception e) {
		    throw new RuntimeException(e);
		}
	 }
	
}
