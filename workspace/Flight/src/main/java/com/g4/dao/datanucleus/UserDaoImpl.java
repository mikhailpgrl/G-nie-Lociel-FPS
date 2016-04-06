package com.g4.dao.datanucleus;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Users;
import com.g4.dao.UserDao;

@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao{

	private PersistenceManagerFactory pmf;
	
	public UserDaoImpl(PersistenceManagerFactory pmf){
		
		this.pmf = pmf;
		
	}
	
	/* 
	 * *token* is not used in the request. login is efficient 
	 * I suppose the login is unique
	 * 
	 * */ 
	public Users getUser(String login, String token){
		
		List<Users> users = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		
		try{
			tx.begin();
			Query q = pm.newQuery(Users.class);
			q.setFilter("login == ? ");
			q.setFilter("token == ? ");
			users = (List<Users>) q.execute(login,token);
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}
		
		if(users == null || users.size() == 0)
			return null;
		else
			return users.get(0);
	}
	
	/*
	public boolean isUserExist(String login){
		
		List<Users> users = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try{
			// I am not sure if this piece of code works
			tx.begin();
			Query q = pm.newQuery(Users.class);
			q.setFilter("login == log ");
			q.declareParameters("String log");
			users = (List<Users>) q.execute(login);
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}
		
		if(users == null || users.size()== 0)
			return false;
		else
			return users.get(0).getLogin().equalsIgnoreCase(login) ? true:false;
	}
	*/
}





