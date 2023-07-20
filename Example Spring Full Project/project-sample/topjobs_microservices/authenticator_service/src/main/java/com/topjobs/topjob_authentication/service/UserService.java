package com.topjobs.topjob_authentication.service;


import com.topjobs.topjob_authentication.exception.DuplicateUsernameException;
import com.topjobs.topjob_authentication.exception.UsernameNotFoundException;
import com.topjobs.topjob_authentication.model.User;


public interface UserService {
	

	public User registerUser(User user) throws DuplicateUsernameException;
	
	boolean	login(String username,String password, String role) throws UsernameNotFoundException;
	
}
