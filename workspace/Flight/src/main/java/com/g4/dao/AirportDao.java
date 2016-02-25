package com.g4.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.dao.datanucleus.Airport;

public class AirportDao {

	
	public static void add(String icao, String name, String city, String country){
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try{
			
			tx.begin();
			Airport usr = new Airport(icao,name,city,country);
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
	public static List<Airport> selectAll(){
		
		List<Airport> airports = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{
			
			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + Airport.class.getName());
			airports = (List<Airport>) q.execute();
			tx.commit();
			
		}finally{
			
			if(tx.isActive()){
				
				tx.rollback();
			}
			pm.close();
		}
		
		return airports;
	}
	
}