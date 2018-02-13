package me.guendouz.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import me.guendouz.todoapp.entity.User;

public class UserDAO {

	private DataSource dataSource;

	public UserDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void create(User user) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = dataSource.getConnection();
			statement = connection
					.prepareStatement("INSERT INTO USER (name, username, password, photo) VALUES (?,?,?,?)");
			statement.setString(1, user.getName());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getPhoto());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update(User user) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = dataSource.getConnection();
			statement = connection
					.prepareStatement("UPDATE USER SET name = ?, username = ?, password = ?, photo = ? WHERE id = ?");
			statement.setString(1, user.getName());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getPhoto());
			statement.setInt(5, user.getId());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delete(User user) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("DELETE FROM USER WHERE id = ?");
			statement.setInt(1, user.getId());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<User> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList<User> users = new ArrayList<>();

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("SELECT * FROM USER ORDER BY id");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				users.add(new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("photo")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return users;
	}

	public User login(String username, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		User user = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("SELECT * FROM USER WHERE username = ? AND password = ? LIMIT 1");
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("photo"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return user;
	}

}
