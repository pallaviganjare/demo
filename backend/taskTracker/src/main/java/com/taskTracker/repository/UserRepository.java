package com.taskTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.taskTracker.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	@Query("{ 'emailId' : ?0 }")
	User findByEmailId(String emailId);
}
