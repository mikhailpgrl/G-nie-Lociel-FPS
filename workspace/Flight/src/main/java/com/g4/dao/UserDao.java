package com.g4.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.dao.datanucleus.User;

public class UserDao {

	
	public static void add(String name, String first_name, String phone_number, 
				String mail_number, String user_type){
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try{
			
			tx.begin();
			User usr = new User(name,first_name,phone_number,mail_number,user_type);
			pm.makePersistent(usr);
			tx.commit();
			
		}finally{
			
			if(tx.isActive()){
				
				tx.rollback();
			}
			pm.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<User> selectAll(){
		
		List<User> users = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{
			
			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + User.class.getName());
			users = (List<User>) q.execute();
			tx.commit();
			
		}finally{
			
			if(tx.isActive()){
				
				tx.rollback();
			}
			pm.close();
		}
		
		return users;
	}
	
}