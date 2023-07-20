package com.topjobs.Employer.test.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.topjobs.Employer.exception.EmployerAlreadyExistException;
import com.topjobs.Employer.exception.EmployerNotFoundException;
import com.topjobs.Employer.model.Employer;
import com.topjobs.Employer.repository.EmployerRepository;
import com.topjobs.Employer.service.EmployerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class EmployerServiceImplTest {
	
	@Mock
	EmployerRepository repo;
	
	Employer employer;
	Employer employerone;
	
	@InjectMocks
	EmployerServiceImpl service;
	
	List<Employer> employerlist = null;
	
	Optional<Employer> options;

	
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
		
		employerone = new Employer();
		employerone.setUsername("TestUserone");
		employerone.setFirstname("TestFirstnameone");
		employerone.setLastname("TestLastnameone");
		employerone.setEmail("Testone@gmail.com");
		employerone.setCompanyName("CGI");
		employerone.setPhoneNumber(989826660);
		employerone.setAccountStatus(true);
		
		employerlist = new ArrayList<>();
		employerlist.add(employer);
		employerlist.add(employerone);
		options = Optional.of(employer);
	}

    @Test
    public void registerEmployerSuccess() throws EmployerAlreadyExistException {
    	//as we need to go through if, obj should be Optional.empty for positive scenario
    	when(repo.findById(employer.getUsername())).thenReturn(Optional.empty());
      //  when(repo.save(employer)).thenReturn(employer);
        Employer empSaved = service.registerEmployer(employer);
        assertEquals(employer, empSaved);
    }
    
    @Test
    public void registerUserFailure() throws EmployerAlreadyExistException {
    	//as we need to go through else, obj should be Optional.empty for negative scenario
    	when(repo.findById(employer.getUsername())).thenReturn(Optional.of(employer));
      //  when(repo.save(employer)).thenReturn(null);
        assertThrows(
        		EmployerAlreadyExistException.class,
                () -> { service.registerEmployer(employer); });
    }
	
    @Test
    public void viewEmployerTestSuccess() {
    	
        when(repo.findAll()).thenReturn(employerlist);
        List<Employer> fetchedEmployer = service.viewAllEmployer();
        assertThat(fetchedEmployer, is(employerlist));
    }
    @Test
    public void viewEmployerTestFailure() {
    	
        when(repo.findAll()).thenReturn(null);
        List<Employer> fetchedEmployer = service.viewAllEmployer();
        assertEquals(fetchedEmployer, null);
    }
    
    
    
    @Test
    public void viewEmployerByIdSuccess() throws EmployerNotFoundException {
        when(repo.findById("TestUser")).thenReturn(Optional.of(employer));
        Employer fetechedEmployer = service.viewEmployerById("TestUser");
        assertEquals(employer, fetechedEmployer);
    }
    @Test
    public void viewEmployerByIdFailure() throws EmployerNotFoundException {
        when(repo.findById("TestUser")).thenReturn(Optional.empty());
        
        assertThrows(
        		EmployerNotFoundException.class,
                    () -> { service.viewEmployerById("TestUser"); });       
    }
    
    @Test
    public void updateEmployerSuccess() throws EmployerNotFoundException {
        when(repo.findById(employer.getUsername())).thenReturn(Optional.of(employer));
        employer.setCompanyName("Amazon");
        Employer fetchedemp = service.updateEmployer(employer, employer.getUsername());
        assertEquals(employer, fetchedemp);
    }
    
    @Test
    public void updateEmployeFailure() throws EmployerNotFoundException {

        when(repo.findById("TestUser")).thenReturn(Optional.empty());
        employer.setCompanyName("Amazon");
      
        assertThrows(
        		EmployerNotFoundException.class,
                    () -> { service.updateEmployer(employer, employer.getUsername()); });
    }
    
    @Test
    public void updateAccountStatusSuccess() throws EmployerNotFoundException {
        when(repo.findById(employer.getUsername())).thenReturn(options);
        employer.setAccountStatus(true);
        boolean fetchedstatus = service.updateAccountStatus(employer.getUsername(), employer.isAccountStatus());
        assertEquals(employer.isAccountStatus(), fetchedstatus);
    }
    
  @Test
  public void updateAccountStatusFailure() throws EmployerNotFoundException {

      when(repo.findById("TestUser")).thenReturn(Optional.empty());;
      employer.setAccountStatus(true);
    
      assertThrows(
      		EmployerNotFoundException.class,
                  () -> { service.updateAccountStatus(employer.getUsername(), employer.isAccountStatus()); });
  }
    
    @Test
    public void deleteEmployerByIdSuccess() throws Exception {
        when(repo.findById(employer.getUsername())).thenReturn(options);
      //  when(repo.save(employer)).thenReturn(employer);
        boolean flag = service.deleteEmployerById("TestUser");
        assertEquals(true, service.deleteEmployerById(employer.getUsername()));
    }
    
    @Test
    public void deleteEmployerByIdFailure() throws EmployerNotFoundException {
    	  when(repo.findById(employer.getUsername())).thenReturn(Optional.empty());
    	//  when(repo.save(employer)).thenReturn(employer);
       // boolean flag = service.deleteEmployerById("TestUser");
        assertThrows(
        		EmployerNotFoundException.class,
                    () -> { service.deleteEmployerById("TestUser"); });
    }
    
    
    @Test
    public void viewEmployerByStatusTestSuccess() {
    	boolean status = employer.isAccountStatus();
        when(repo.findAllEmployerByAccountStatus(status)).thenReturn(employerlist);
        List<Employer> fetchedEmployer = service.viewEmployerByStatus(false);
        assertThat(fetchedEmployer, is(employerlist));
    }
	
    @Test
    public void viewEmployerByStatusTestFailure() {
    	boolean status = employerone.isAccountStatus();
        when(repo.findAllEmployerByAccountStatus(status)).thenReturn(null);
        List<Employer> fetchedEmployer = service.viewEmployerByStatus(true);
        assertEquals(fetchedEmployer, null);

    }
	

}
