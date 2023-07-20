package com.topjobs.Employer.test.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.topjobs.Employer.model.Employer;
import com.topjobs.Employer.repository.EmployerRepository;

@ExtendWith(SpringExtension.class)

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class EmployerRepositoryTest {
	
	@Autowired
	private EmployerRepository repo;
	private Employer employer;
	
	@BeforeEach
	public void setUp() throws Exception{
		employer = new Employer();
		employer.setUsername("TestUser");
		employer.setFirstname("TestFirstname");
		employer.setLastname("TestLastname");
		employer.setEmail("Test@gmail.com");
		employer.setCompanyName("CGI");
		employer.setPhoneNumber(989824010);
		employer.setAccountStatus(false);
		
	}
	
	@AfterEach
	public void tearDown() throws Exception{
		repo.deleteAll();
	}
	
	@Test
    public void registerEmployerTest() {

    	repo.insert(employer);
        Employer fetchedemp = repo.findById("TestUser").get();
        
        assertEquals(employer.getUsername(), fetchedemp.getUsername());
    }
	
	 @Test
	 public void viewEmployerByIdTest() {
	    	repo.insert(employer);
	    	Employer fetchedemp = repo.findById("TestUser").get();
	        assertEquals(employer.getUsername(), fetchedemp.getUsername());
	 }
	 
	 @Test
	 public void updateAccountStatusTest() {
		 repo.insert(employer);
		 Employer fetchedemp = repo.findById("TestUser").get();
		 fetchedemp.setAccountStatus(true);
		 assertNotEquals(employer.isAccountStatus(), fetchedemp.isAccountStatus());
	 }
	 
	 
    @Test
    public void updateEmployerTest() {
    	repo.insert(employer);
    	Employer fetchedemp = repo.findById("TestUser").get();
    	
    	fetchedemp.setPhoneNumber(987654321);
        repo.save(fetchedemp);
        
        fetchedemp = repo.findById("TestUser").get();
        assertEquals(987654321, fetchedemp.getPhoneNumber());
    }
    
   
    @Test
    public void viewAllEmployer() {
    	 
    	  Employer employer1 = new Employer();
    	    employer1.setUsername("TestUser2");
	  		employer1.setFirstname("TestFirstname2");
	  		employer1.setLastname("TestLastname2");
	  		employer1.setEmail("Test2@gmail.com");
	  		employer1.setCompanyName("CGI");
	  		employer1.setPhoneNumber(1234567891);
	  		
	  		repo.insert(employer);
	  		repo.insert(employer1);
	  		 
	  		List<Employer> emplist = repo.findAll();
	  		
	  		assertEquals(emplist.size(), 2);
    }
    
    @Test
    public void deleteEmployerById() {
    	repo.insert(employer);
    	Employer fetchedemp = repo.findById("TestUser").get();
        assertEquals("TestUser", fetchedemp.getUsername());
        repo.delete(fetchedemp);
        
        try {
        	
        	repo.findById("TestUser").get();
        	
        }catch(Exception exception) {
        	assertEquals(NoSuchElementException.class, exception.getClass());
        }

    }
	 
	 
	
}
