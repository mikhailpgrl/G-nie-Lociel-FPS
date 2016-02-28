package com.g4.dao.plug;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Flight;
import com.g4.beans.FlightPer;
import com.g4.beans.User;

public class FlightPerPlug implements FlightPerDao {

	public FighterPlug(){

	}

	public String add(Flight flight, User user){

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{

			tx.begin();
			FlightPer fp = new FlightPer(flight, user);
			pm.makePersistent(fp);
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
	public static ArrayList<FlightPer> selectAll(){

		ArrayList<FlightPer> assoc = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{

			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + FlightPer.class.getName());
			assoc = (ArrayList<FlightPer>) q.execute();
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}

		return assoc;
	}

}
