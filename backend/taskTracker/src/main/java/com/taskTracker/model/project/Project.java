package com.taskTracker.model.project;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("project")
public class Project {
	String name;
	String _id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
}
