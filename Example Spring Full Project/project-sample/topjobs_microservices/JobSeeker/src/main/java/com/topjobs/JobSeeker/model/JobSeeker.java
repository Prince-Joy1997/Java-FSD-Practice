package com.topjobs.JobSeeker.model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class JobSeeker {
	// Attributes
	@Id
	private String username;
	private String firstName, lastName, email, address, resume;
	private long phoneNumber;
	private List<Application> applicationList;

	
	// Constructors
	public JobSeeker(String username, String firstName, String lastName, String email, String address, String resume,
			long phoneNumber, List<Application> applicationList) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.resume = resume;
		this.phoneNumber = phoneNumber;
		this.applicationList = applicationList;
	}

	public JobSeeker() {
	}

	// Getters Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Application> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<Application> applicationList) {
		this.applicationList = applicationList;
	}
	
	// toString
	@Override
	public String toString() {
		return "JobSeeker [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", address=" + address + ", resume=" + resume + ", phoneNumber=" + phoneNumber
				+ ", applicationList=" + applicationList + "]";
	}
}
