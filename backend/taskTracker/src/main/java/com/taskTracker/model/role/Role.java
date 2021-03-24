package com.taskTracker.model.role;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("role")
public class Role {
	String name;
	String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
