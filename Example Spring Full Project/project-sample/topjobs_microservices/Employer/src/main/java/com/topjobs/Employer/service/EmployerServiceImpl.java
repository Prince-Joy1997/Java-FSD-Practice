package com.topjobs.Employer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topjobs.Employer.exception.EmployerAlreadyExistException;
import com.topjobs.Employer.exception.EmployerNotFoundException;
import com.topjobs.Employer.model.Employer;
import com.topjobs.Employer.repository.EmployerRepository;

@Service
public class EmployerServiceImpl implements EmployerService{
	
	@Autowired
	EmployerRepository repo;
	

	@Override
	public Employer registerEmployer(Employer employer) throws EmployerAlreadyExistException {
		
		Optional<Employer> addEmployer = repo.findById(employer.getUsername());
		
		if(addEmployer.isEmpty()) {
			repo.save(employer);
			return employer ;
		}
		else {
			throw new EmployerAlreadyExistException("Employer with " + employer.getUsername() + "Already Exists");
		}
	}

	@Override
	public List<Employer> viewAllEmployer() {	
		return repo.findAll();
	}

	@Override
	public Employer viewEmployerById(String username) throws EmployerNotFoundException {
		
	 Optional<Employer> viewEmp = repo.findById(username);
	 
	 if(viewEmp.isPresent()) {
		 return viewEmp.get();
	 }
	 else {
		 throw new EmployerNotFoundException("Employer with :"+username+"not found");
	 }
	}

	@Override
	public Employer updateEmployer(Employer employer, String username) throws EmployerNotFoundException {
		 	
	Optional<Employer> optEmp =	repo.findById(username);

		if(optEmp.isPresent()) {
			 Employer empl = optEmp.get();
			 empl.setUsername(username);
			repo.save(employer);
			return employer;
		}
		else {
			throw new EmployerNotFoundException("Employer Not Exist");
		}
	}

	@Override
	public boolean updateAccountStatus(String username, boolean accountStatus) throws EmployerNotFoundException {
		
		Optional<Employer> optEmp = repo.findById(username);
		
		if(optEmp.isPresent()) {
			Employer empl = optEmp.get();
			empl.setAccountStatus(accountStatus);
			repo.save(empl);
			return true;
		}
		else {
			throw new EmployerNotFoundException("Employer Not Exist");
		}
	
	}

	@Override
	public boolean deleteEmployerById(String username) throws EmployerNotFoundException {
		Optional<Employer> optEmp = repo.findById(username);
		
		if(optEmp.isEmpty()) {
			throw new EmployerNotFoundException("Employer not found");
		}
		else {
			repo.deleteById(username);
			return true;
		}
	}

	@Override
	public List<Employer> viewEmployerByStatus(boolean accountStatus) {
		
		return repo.findAllEmployerByAccountStatus(accountStatus);
	}

	

}
