package com.topjobs.Employer.service;

import java.util.List;

import com.topjobs.Employer.exception.EmployerAlreadyExistException;
import com.topjobs.Employer.exception.EmployerNotFoundException;
import com.topjobs.Employer.model.Employer;

public interface EmployerService {
	
	public Employer registerEmployer (Employer employer) throws EmployerAlreadyExistException;
	
	public List<Employer> viewAllEmployer();

	public Employer viewEmployerById(String username) throws EmployerNotFoundException;
	
	public Employer updateEmployer(Employer employer, String username) throws EmployerNotFoundException; 
	
	public boolean updateAccountStatus(String username, boolean accountStatus) throws EmployerNotFoundException;
	
	public boolean deleteEmployerById(String username) throws EmployerNotFoundException;
	
	public List<Employer> viewEmployerByStatus(boolean accountStatus);
	

}
