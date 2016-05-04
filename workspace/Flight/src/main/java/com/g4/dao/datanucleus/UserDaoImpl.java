package com.g4.dao.datanucleus;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Users;
import com.g4.dao.UserDao;

@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao{

	
	public UserDaoImpl(){
		
	}
	
	/* 
	 * *token* is not used in the request. login is efficient 
	 * I suppose the login is unique
	 * 
	 * */ 
	public Users getUser(String login, String token){

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		List<Users> users = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		System.out.println(login);
		try{
			tx.begin();
			Query q = pm.newQuery(Users.class);
//			q.setFilter("login == ? ");
//			q.setFilter("token == ? ");
			q.setFilter("login == login ");
			q.declareParameters("String login");
			users = (List<Users>) q.execute(login);
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}
		
		if(users == null || users.size() == 0)
			return null;
		else{
			Users us =null;
			for (Users u : users) {
				if (u.getLogin().equals(login) && u.getPassword().equals(token)){
					us=u;
				}
			}
			
			if (us !=null)
				return us;
			else
				return null;
			
		}
	}

	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
			List<Users> users = null;
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();

			try{

				tx.begin();
				Query q = pm.newQuery(Users.class);
				users =  (List<Users>) q.execute();
				tx.commit();

			}finally{

				if(tx.isActive()){

					tx.rollback();
				}
				pm.close();
			}

			if(users.isEmpty())
				return null;
			else
				return users;
	}
	
	public String putUser(Users user) {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(user);
			tx.commit();
			
		} finally {
			
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return "success";
		
	}
	
	public String deleteUser(String id) {
		// TODO Auto-generated method stub
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
		    
		    tx.begin();
		    Query q = pm.newQuery(Users.class);
			q.setFilter("id == userId ");
			q.declareParameters("int userId");
			q.deletePersistentAll(Integer.parseInt(id));
		    tx.commit();
		}
		catch (Exception e)
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		}
		
			return "succes";
	}	
	
	
	
}





