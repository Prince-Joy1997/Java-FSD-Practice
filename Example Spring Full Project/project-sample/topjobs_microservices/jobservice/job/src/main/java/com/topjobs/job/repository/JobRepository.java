package com.topjobs.job.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.topjobs.job.model.Job;

@Repository
public interface JobRepository extends MongoRepository<Job,String>{
	List<Job> findAllJobByEmployerId(String employerId);

}
