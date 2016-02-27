package com.g4.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.dao.datanucleus.Airport;
import com.g4.dao.datanucleus.Flight;

public class FlightDao {

	public static void add(String cm, String atc, 
			Airport depart_airport, Airport arriv_airport, 
			String depart_date, String arriv_date, 
			String depart_hour, String arriv_hour){
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try{
			
			tx.begin();
			Flight fl = new Flight(cm, atc,depart_airport,arriv_airport,
									depart_date,arriv_date,
									depart_hour,arriv_hour);
			pm.makePersistent(fl);
			tx.commit();
			
		}finally{
			
			if(tx.isActive()){
				
				tx.rollback();
			}
			pm.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Flight> selectAll(){
		
		List<Flight> flights = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{
			
			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + Flight.class.getName());
			flights = (List<Flight>) q.execute();
			tx.commit();
			
		}finally{
			
			if(tx.isActive()){
				
				tx.rollback();
			}
			pm.close();
		}
		
		return flights;
	}
	
}