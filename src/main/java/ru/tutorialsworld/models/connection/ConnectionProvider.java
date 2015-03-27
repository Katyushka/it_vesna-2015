package ru.tutorialsworld.models.connection;

import java.sql.*;

import static ru.tutorialsworld.models.connection.Provider.*;

public class ConnectionProvider {
	static Connection connnection = null;
	static {
		try {
			Class.forName(DRIVER);
			connnection = DriverManager.getConnection(CONNECTION_URL, USERNAME,
					PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connnection;
	}
}
