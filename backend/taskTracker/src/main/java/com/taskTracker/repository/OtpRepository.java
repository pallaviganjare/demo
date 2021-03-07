package com.taskTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.taskTracker.Model.Otp;

@Repository
public interface OtpRepository extends MongoRepository<Otp,String> {

	@Query("{ 'emailId' : ?0 }")
	Otp findByEmailId(String emailId);
	
	@Query("{'emailId' : ?0}")
	void deleteByEmail(String emailId);
}
