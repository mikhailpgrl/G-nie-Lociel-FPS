package com.g4.dao;

import com.g4.beans.User;

public interface UserDao {

	User getUser(String login, String token);

	public ArrayList<User> getAllUsers();

	String deleteUser(String id);

	public void modifyUser(User user)

	public String PutUser(String name, String first_name, String phone_number,
				String mail_number, String user_type);
}
