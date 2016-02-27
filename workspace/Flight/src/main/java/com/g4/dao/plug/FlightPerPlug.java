package com.g4.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.dao.datanucleus.Flight;
import com.g4.dao.datanucleus.FlightPer;
import com.g4.dao.datanucleus.User;

public class FlightPerPlug {

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
	public static List<FlightPer> selectAll(){
		
		List<FlightPer> assoc = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{
			
			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + FlightPer.class.getName());
			assoc = (List<FlightPer>) q.execute();
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
