package com.g4.dao.plug;

import com.g4.beans.User;
import com.g4.dao.UserDao;

public class UserPlug implements UserDao{

	public User getUser(String login, String token) {
		// TODO Auto-generated method stub
		return new  User("testtt");
		//return null;
	}

}
