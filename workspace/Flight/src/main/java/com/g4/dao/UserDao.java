package com.g4.dao;

import java.util.ArrayList;

import com.g4.beans.User;

public interface UserDao {

	User getUser(String login, String token);

	public ArrayList<User> getAllUsers();

	String deleteUser(String id);

	public void modifyUser(User user);

	public String putUser(String login, String pwd, String user_type);
}
