package ru.tutorialsworld.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ru.tutorialsworld.models.connection.ConnectionProvider;
import ru.tutorialsworld.models.entities.User;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserName(String userName) {
		User user = null;
		try {
			String query = "SELECT * FROM users WHERE username = ?";
			PreparedStatement pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int idParam = rs.getInt("id");
				String userNameParam = rs.getString("username");
				String passwordParam = rs.getString("password");
				String saltParam = rs.getString("salt");
				user = new User(idParam, userNameParam, passwordParam,
						saltParam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User createUser(String userName, String password, String salt) {
		User newUser = null;
		try {
			String query = "INSERT INTO users (username, password, salt) VALUES (?, ?, ?)";
			PreparedStatement pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			pstmt.setString(3, salt);
			int success = pstmt.executeUpdate();
			query = "SELECT * FROM users WHERE username = ?";
			pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int idParam = rs.getInt("id");
				String userNameParam = rs.getString("username");
				String passwordParam = rs.getString("password");
				String saltParam = rs.getString("salt");
				newUser = new User(idParam, userNameParam, passwordParam,
						saltParam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newUser;
	}

	@Override
	public User deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User changeUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	private Connection getConnection() {
		return ConnectionProvider.getConnection();
	}
}
