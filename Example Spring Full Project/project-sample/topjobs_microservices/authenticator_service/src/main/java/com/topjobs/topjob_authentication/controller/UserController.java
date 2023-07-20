package com.topjobs.topjob_authentication.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topjobs.topjob_authentication.exception.DuplicateUsernameException;
import com.topjobs.topjob_authentication.exception.UsernameNotFoundException;
import com.topjobs.topjob_authentication.model.User;
import com.topjobs.topjob_authentication.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> loginUser(@RequestBody User userobj) 
	{
		 String checkRole = userobj.getRole();
		 
		 boolean result;
		try {
			result = service.login(userobj.getUsername(), userobj.getPassword(), userobj.getRole());
			if( result)
			 {
				 String mytoken=generateToken(userobj); 
				  HashMap mymap=new HashMap();
				  mymap.put("token",mytoken);
				  return new ResponseEntity<HashMap>(mymap,HttpStatus.OK);
			 } 
			else
			{
				return new ResponseEntity<String>("Invalid username/password",HttpStatus.UNAUTHORIZED);
			}

		} catch (UsernameNotFoundException e) {
			return new ResponseEntity<String>("Username not found",HttpStatus.CONFLICT);
		}
	}
		 

	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody User userobj)
	{
		try {
			User user = service.registerUser(userobj);
			return new ResponseEntity<User>(user,HttpStatus.CREATED);

		} catch (DuplicateUsernameException e) {
			return new ResponseEntity<String>("Duplicate user name",HttpStatus.CONFLICT);
		}
	}
	
	
	public String generateToken(User obj)
	{
	//	long expiry=10_000_00;
		
		return Jwts.builder().setSubject(obj.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
	//											.setExpiration(new Date(System.currentTimeMillis()+ expiry ))
												.signWith(SignatureAlgorithm.HS256, "topjobkey")
												.compact();
	}

}
