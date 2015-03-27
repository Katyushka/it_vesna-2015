package ru.tutorialsworld.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import ru.tutorialsworld.models.dao.UserDao;
import ru.tutorialsworld.models.dao.UserDaoImpl;
import ru.tutorialsworld.models.entities.User;

public class UserModel {

	public static User getUser(String userName, String password) {
		User user = getUserByUserName(userName);
		if (checkPassword(password, user)) {
			return user;
		}
		return null;
	}

	public static User getUserByUserName(String userName) {
		UserDao userDao = new UserDaoImpl();
		return userDao.getUserByUserName(userName);
	}

	public static User createUser(String userName, String password) {
		User newUser = null;
		try {
			String salt = getSalt();
			String passwordHash = getMd5(password, salt);
			UserDao userDao = new UserDaoImpl();
			System.out.println(salt + " ----- "+passwordHash);
			newUser = userDao.createUser(userName, passwordHash, salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return newUser;
	}

	private static boolean checkPassword(String password, User user) {
		try {
			if (getMd5(password, user.getSalt()).equals(user.getPassword())) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static String getMd5(String password, String salt)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(salt.getBytes());
		byte[] bytes = md.digest(md.digest(password.getBytes()));
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return sb.toString();
	}

	private static String getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[12];
		sr.nextBytes(salt);
		return salt.toString();
	}
}
