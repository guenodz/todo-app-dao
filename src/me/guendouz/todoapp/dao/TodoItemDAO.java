package me.guendouz.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import me.guendouz.todoapp.entity.TodoItem;

public class TodoItemDAO {

	private DataSource dataSource;

	public TodoItemDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void create(TodoItem item) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(
					"INSERT INTO TodoItem (title, content, creationDate, alarmDate, priority, color, userId) VALUES (?,?,?,?,?,?,?)");
			statement.setString(1, item.getTitle());
			statement.setString(2, item.getContent());
			statement.setDate(3, item.getCreationDate());
			statement.setDate(4, item.getAlarm());
			statement.setInt(5, item.getPriority());
			statement.setString(6, item.getColor());
			statement.setInt(7, item.getUserID());

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

	public void update(TodoItem item) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(
					"UPDATE TodoItem SET title = ?, content = ?, alarmDate = ?, priority = ?, color = ? WHERE id = ?");
			statement.setString(1, item.getTitle());
			statement.setString(2, item.getContent());
			statement.setDate(3, item.getAlarm());
			statement.setInt(4, item.getPriority());
			statement.setString(5, item.getColor());

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

	public void delete(TodoItem item) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("DELETE FROM TodoItem WHERE id = ?");
			statement.setInt(1, item.getId());

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

	public ArrayList<TodoItem> findAllByUser(int userId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList<TodoItem> items = new ArrayList<>();

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("SELECT * FROM TodoItem WHERE userId = ? ORDER BY id");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				items.add(new TodoItem(resultSet.getInt("id"), resultSet.getString("title"),
						resultSet.getString("content"), resultSet.getDate("creationDate"),
						resultSet.getDate("alarmDate"), resultSet.getInt("prority"), resultSet.getString("color"),
						resultSet.getInt("userId")));

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

		return items;
	}

	public TodoItem findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		TodoItem item = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("SELECT * FROM TodoItem WHERE id = ? LIMIT 1");
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				item = new TodoItem(resultSet.getInt("id"), resultSet.getString("title"),
						resultSet.getString("content"), resultSet.getDate("creationDate"),
						resultSet.getDate("alarmDate"), resultSet.getInt("prority"), resultSet.getString("color"),
						resultSet.getInt("userId"));

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

		return item;
	}

}
