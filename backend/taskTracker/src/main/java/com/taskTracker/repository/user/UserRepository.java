package com.taskTracker.repository.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.taskTracker.model.user.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	@Query("{ 'emailId' : ?0 }")
	User findByEmailId(String emailId);
}
