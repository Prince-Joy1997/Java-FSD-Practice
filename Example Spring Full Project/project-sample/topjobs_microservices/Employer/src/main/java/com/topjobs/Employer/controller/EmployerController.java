package com.topjobs.Employer.controller;

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

import com.topjobs.Employer.exception.EmployerAlreadyExistException;
import com.topjobs.Employer.exception.EmployerNotFoundException;
import com.topjobs.Employer.model.Employer;
import com.topjobs.Employer.service.EmployerService;

@CrossOrigin
@RestController
@RequestMapping("employer")
public class EmployerController {

	@Autowired
	EmployerService service;
	
	@PostMapping("/registerEmployer")
	public ResponseEntity<?> registerEmployer(@RequestBody Employer employer){

		System.out.println("Username = " + employer.getUsername());
		try {
		   Employer result = service.registerEmployer(employer);
		   	return new ResponseEntity<Employer>(result, HttpStatus.CREATED);
		} catch (EmployerAlreadyExistException e) {
			return new ResponseEntity<String>("Employer "+employer.getUsername()+ " Already Exists", HttpStatus.CONFLICT); 			
		}
	}
	
	@GetMapping("/viewAllEmployer")
	public ResponseEntity<?> viewAllEmployer(){
	List<Employer> employerList = service.viewAllEmployer();
	if(employerList != null) {
		return new ResponseEntity<List>(employerList, HttpStatus.OK);

	}else
		return new ResponseEntity<String>("No Employer is in database", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/viewEmployer/{username}")
	public ResponseEntity<?> viewEmployer(@PathVariable("username") String username){
		try {
		Employer result = service.viewEmployerById(username);
			return new ResponseEntity<Employer>(result, HttpStatus.OK);
		} catch (EmployerNotFoundException e) {
			return new ResponseEntity<String>("Employer " + username+ " Not Found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateEmployer/{username}")
	public ResponseEntity<?> updateEmployer(@PathVariable("username") String username, @RequestBody Employer employer){
		try {
		       Employer result = service.updateEmployer(employer, username);
		       return new ResponseEntity<Employer>(result, HttpStatus.OK);
		} catch (EmployerNotFoundException e) {
			return new ResponseEntity<String>("Employer does Not Found", HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping("/updateAccountStatus/{username}/{accountStatus}")
	public ResponseEntity<?> updateaccountStatus(@PathVariable("username") String username, @PathVariable("accountStatus") boolean AccountStatus){
		try {
		       boolean result = service.updateAccountStatus(username, AccountStatus);
		       if(result) {
					return new ResponseEntity<String>("Account Status Updated", HttpStatus.OK);
				}
				else{
					return new ResponseEntity<String>("Could not find the given Username", HttpStatus.NOT_FOUND);
				} 
		} catch (EmployerNotFoundException e) {
			
			return new ResponseEntity<String>("Employer does Not Found", HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/deleteEmployer/{username}")
	public ResponseEntity<?> deleteEmployer(@PathVariable("username") String username){
		try {
			boolean result = service.deleteEmployerById(username);
			
			if(result) {
				return new ResponseEntity<String>("Employer Deleted Successfully", HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Could not find the given ID", HttpStatus.NOT_FOUND);
			}
		} catch (EmployerNotFoundException e) {
			return new ResponseEntity<String>("Employer does Not Found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/viewEmployerBystatus/{accountStatus}")
	public ResponseEntity<?> getEmployersBystatus(@PathVariable("accountStatus") boolean accountStatus){
		
		List<Employer> result = service.viewEmployerByStatus(accountStatus);
		
		if(result == null) {
			return new ResponseEntity<String>("No Employers found", HttpStatus.NOT_FOUND); 
		}
		else {
			return new ResponseEntity<List>(result, HttpStatus.OK);
		}
	}

}
