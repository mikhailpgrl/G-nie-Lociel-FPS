package com.g4.dao.plug;

import com.g4.beans.Users;
import com.g4.dao.UserDao;

public class UserPlug implements UserDao{

	public Users getUser(String login, String token) {
		// TODO Auto-generated method stub
		return new  Users("testtt");
		//return null;
	}

}
