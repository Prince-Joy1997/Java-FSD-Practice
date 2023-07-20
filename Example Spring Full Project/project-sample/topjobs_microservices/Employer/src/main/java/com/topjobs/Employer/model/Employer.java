package com.topjobs.Employer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employer {

	@Id
	String username;
	String firstname;
	String lastname;
	String email;
	String companyName;
	Number phoneNumber;
	String address;
	boolean accountStatus;
	
	public Employer() {}
	
	public Employer(String username, String firstname, String lastname, String email, String companyName,
					Number phoneNumber, String address, boolean accountStatus) {
		
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.accountStatus = accountStatus;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Number getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Number phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public String toString() {
		return "Employer{" + "Employer Id:" + username + " First Name:" + firstname + "Last Name:" + lastname + " Company Name:"+ companyName +
				" email address" + email + " Phone Number" + phoneNumber + "Address" + address + " Account Status" + accountStatus;
		
	}
	 
}
