package com.topjobs.topjob_authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topjobs.topjob_authentication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByUsernameAndPasswordAndRole(String username,String password, String role);
}
