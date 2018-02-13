package me.guendouz.todoapp;

import org.sqlite.SQLiteDataSource;

import me.guendouz.todoapp.dao.UserDAO;
import me.guendouz.todoapp.entity.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLiteDataSource dataSource = new SQLiteDataSource();
		dataSource.setUrl("jdbc:sqlite:todo-db.db");
		System.out.println(dataSource.getUrl());
		
		UserDAO dao = new UserDAO(dataSource);
		User user = new User(0,"Mohamed Guendouz","gueno","pass","photo");
		dao.create(user);
		System.out.println(dao.findAll().size());
		
	}

}
