package com.g4.dao.plug;

import com.g4.beans.User;
import com.g4.dao.UserDao;

public class UserPlug implements UserDao{

	public UserPlug(){

		putUser("admin","admin","cco");
		putUser("Reimu","toto","crew");
	}

	public String putUser(String login, String pwd, String user_type){

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{

			tx.begin();
			User usr = new User(login,pwd,ty);
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
	public ArrayList<User> getAllUsers(){

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
									+ User.class.getName() + ".login=" + login);
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
	}

	public void modifyUser(User user){

		/// TODO modification
	}

	public String deleteUser(String id)
	{
			return "TODO";
	}
}
