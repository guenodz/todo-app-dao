package me.guendouz.todoapp.entity;

import java.sql.Date;

public class TodoItem {

	private int id;
	private String title;
	private String content;
	private Date creationDate;
	private Date alarm;
	private int priority;
	private String color;
	private int userID;

	public TodoItem() {

	}

	public TodoItem(int id, String title, String content, Date creationDate, Date alarm, int priority, String color,
			int userID) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
		this.alarm = alarm;
		this.priority = priority;
		this.color = color;
		this.userID = userID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getAlarm() {
		return alarm;
	}

	public void setAlarm(Date alarm) {
		this.alarm = alarm;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
