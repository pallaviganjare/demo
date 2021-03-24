package com.taskTracker.repository.task;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.taskTracker.model.task.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{

}
