package com.g4.dao.plug;

import com.g4.beans.User;
import com.g4.dao.UserDao;

public class UserPlug implements UserDao{

<<<<<<< HEAD
	public UserPlug(){
		
	}
	
	public String add(String name, String first_name, String phone_number, 
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
		
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public static List<User> getAllUsers(){
		
		ArrayList<User> users = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{
			
			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + User.class.getName());
			users = (ArrayList<User>) q.execute();
			tx.commit();
			
		}finally{
			
			if(tx.isActive()){
				
				tx.rollback();
			}
			pm.close();
		}
		
		return users;
	}


	public User getUser(String login, String token) {
		
		ArrayList<User> users = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{
			
			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + User.class.getName() + "WHERE" 
									+ User.class.getName() + ".id=" + id);
			users = (ArrayList<User>) q.execute();
			tx.commit();
			
		}finally{
			
			if(tx.isActive()){
				
				tx.rollback();
			}
			pm.close();
		}
		
		if(users != null)
			return users[0];
		
		return null;
=======
	public User getUser(String login, String token) {
		// TODO Auto-generated method stub
		return new  User("testtt");
		//return null;
>>>>>>> 7d53fb47e5629b5cfab22c2f2378cead8f923edd
	}

}
