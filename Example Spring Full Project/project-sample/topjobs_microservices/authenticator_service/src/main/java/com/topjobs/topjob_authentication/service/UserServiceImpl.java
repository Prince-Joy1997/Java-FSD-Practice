package com.topjobs.topjob_authentication.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topjobs.topjob_authentication.exception.DuplicateUsernameException;
import com.topjobs.topjob_authentication.exception.UsernameNotFoundException;
import com.topjobs.topjob_authentication.model.User;
import com.topjobs.topjob_authentication.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repo;
	
	@Override
	public User registerUser(User user) throws DuplicateUsernameException{
		
		Optional<User> userobj = repo.findById(user.getUsername());
		
		if(userobj.isEmpty())
			repo.save(user);
		else
			throw new DuplicateUsernameException();
		
		return user;
	}



	@Override
	public boolean login(String username, String password, String role) throws UsernameNotFoundException {
		 User userobj= repo.findByUsernameAndPasswordAndRole(username,password,role);
		  
		  if(userobj==null)
			  throw new UsernameNotFoundException();
		  else
			  return true;
		}

	
}


