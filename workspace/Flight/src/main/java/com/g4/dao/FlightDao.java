package com.g4.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import dao.datanucleus.Airport;
import dao.datanucleus.Flight;

public class FlightDao {

	public static void add(String cm, String atc, 
			Airport depart_airport, Airport arriv_airport, 
			String depart_date, String arriv_date, 
			String depart_hour, String arriv_hour){
		
		Object airportID1 = null;
		Object airportID2 = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		// Get ids
		try{
			airportID1 = JDOHelper.getObjectId(depart_airport);
			airportID2 = JDOHelper.getObjectId(arriv_airport);
			
		}catch(Exception e){
			System.out.print("Error while adding the flight " + e.getMessage());
			throw e;
		}finally{
			
			if(tx.isActive()){
				
				tx.rollback();
			}
			pm.close();
		}
		
		// Update the persistence Manager
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		
		// Relationship between the flight and the airports
		try{
			
			tx.begin();
			Airport a1 = (Airport)pm.getObjectById(airportID1);
			Airport a2 = (Airport)pm.getObjectById(airportID2);
			
			Flight fl = new Flight(cm, atc,a1,a2,depart_date,
									arriv_date,depart_hour,arriv_hour);
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