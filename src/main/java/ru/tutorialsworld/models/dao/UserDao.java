package ru.tutorialsworld.models.dao;

import java.util.List;

import ru.tutorialsworld.models.entities.User;

public interface UserDao {
	public List<User> getAllUsers();

	public User getUserByUserName(String userName);

	public User createUser(String userName, String password, String salt);

	public User deleteUser(User user);

	public User changeUser(User user);
}
