package com.topjobs.JobSeeker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.topjobs.JobSeeker.model.JobSeeker;

@Repository
public interface JobSeekerRepository extends MongoRepository<JobSeeker, String> {

}
