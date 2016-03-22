package com.g4.dao;

import com.g4.beans.Users;

public interface UserDao {
	
	/**
	 * @param login 
	 * @param token
	 * @return a user or null
	 */
	Users getUser(String login, String token);
	
	// Check if a user exists
	boolean isUserExist(String login);
	
}