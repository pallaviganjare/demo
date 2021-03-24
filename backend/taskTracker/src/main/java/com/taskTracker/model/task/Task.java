package com.taskTracker.model.task;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("task")
public class Task {
	String _id;
	String title;
	String assignedPriority;
	String currentPriority;
	String status;
	long estimatedTime;
	Date dueDate;
	String owner_id;
	long percentageCompleted;
	Date timestamp;
	Comment comments[];
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAssignedPriority() {
		return assignedPriority;
	}
	public void setAssignedPriority(String assignedPriority) {
		this.assignedPriority = assignedPriority;
	}
	public String getCurrentPriority() {
		return currentPriority;
	}
	public void setCurrentPriority(String currentPriority) {
		this.currentPriority = currentPriority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(long estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public long getPercentageCompleted() {
		return percentageCompleted;
	}
	public void setPercentageCompleted(long percentageCompleted) {
		this.percentageCompleted = percentageCompleted;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Comment[] getComments() {
		return comments;
	}
	public void setComments(Comment[] comments) {
		this.comments = comments;
	}
}
