package com.topjobs.Employer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.topjobs.Employer.model.Employer;

@Repository
public interface EmployerRepository extends MongoRepository<Employer, String> {
	List<Employer> findAllEmployerByAccountStatus(boolean accountStatus);
}
