package com.taskTracker.repository.role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.taskTracker.model.role.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {

}
