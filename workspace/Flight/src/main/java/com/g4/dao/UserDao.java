package com.g4.dao;

import java.util.List;

import com.g4.beans.Users;

public interface UserDao {
	
	/**
	 * @param login 
	 * @param token
	 * @return a user or null
	 */
	Users getUser(String login, String token);

	List<Users> getAllUsers();

	String deleteUser(String id);

	String putUser(Users user);
	
	
}