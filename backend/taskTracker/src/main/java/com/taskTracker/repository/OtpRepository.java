package com.taskTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.taskTracker.Model.Otp;

@Repository
public interface OtpRepository extends MongoRepository<Otp,String> {

}
