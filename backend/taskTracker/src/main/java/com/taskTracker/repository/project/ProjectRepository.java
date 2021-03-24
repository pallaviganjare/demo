package com.taskTracker.repository.project;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.taskTracker.model.project.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

}
