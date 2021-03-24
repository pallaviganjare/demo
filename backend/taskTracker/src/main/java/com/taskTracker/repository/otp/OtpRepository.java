package com.taskTracker.repository.otp;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.taskTracker.model.otp.Otp;

@Repository
public interface OtpRepository extends MongoRepository<Otp,String> {

	@Query("{ 'emailId' : ?0 }")
	Otp findByEmailId(String emailId);
	
	Long deleteOtpByEmailId(String emailId);

	@Query(value="{ $where : 'new Date().getTime()-this.timeStamp.getTime()>180000' }",delete=true)
	Long deleteExpiredOtp();
}
