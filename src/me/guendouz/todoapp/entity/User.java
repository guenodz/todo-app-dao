package me.guendouz.todoapp.entity;

public class User {

	private int id;
	private String name;
	private String username;
	private String password;
	private String photo;

	public User() {

	}

	public User(int id, String name, String username, String password, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
