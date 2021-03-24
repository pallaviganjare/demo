package com.taskTracker.service.admin;

import java.util.List;
import java.util.Map;

import com.taskTracker.model.user.User;

public interface AdminService {

	User createUser(User user);

	Map<String,List<String>> getRoles();

}
