package com.g4.dao;

import com.g4.beans.User;

public class UserPlug implements UserDao{

	public User getUser(String login, String token) {
		// TODO Auto-generated method stub
		return new  User("testtt");
		//return null;
	}

}
