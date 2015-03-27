package ru.tutorialsworld.models.connection;

public interface Provider {
	// DEV CONFIG
	/*
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONNECTION_URL = String.format("jdbc:mysql://%s:%s/tw?useUnicode=yes&characterEncoding=UTF-8", "localhost", "3306");
	String USERNAME = "root";
	String PASSWORD = "root"; 
	*/
	// PROD CONFIG
	
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONNECTION_URL = String.format("jdbc:mysql://%s:%s/tw", System.getenv("OPENSHIFT_MYSQL_DB_HOST"), System.getenv("OPENSHIFT_MYSQL_DB_PORT"));
	String USERNAME = "adminItjUwgM";
	String PASSWORD = "zeZkc31Sc2j-";
	
}
