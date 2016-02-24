package com.g4.dao;

import com.g4.beans.User;

public interface UserDao {
	
	/**
	 * @param login 
	 * @param token
	 * @return a user or null
	 */
	User getUser(String login, String token);
	
	
}