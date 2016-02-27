package com.g4.dao.plug;

<<<<<<< HEAD
import java.util.ArrayList;

import com.g4.dao.AirportDao;

import com.g4.beans.Airport;

public class AirportPlug implements AirportDao{


	public AirportPlug(){
		
	}
	
	
	public String addAirport(String icao, String name, String city, String country){
		
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
		
		return "success";
	}
	

	public Airport getAirport(String id) {
		
		ArrayList<Airport> airports = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{
			
			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + Airport.class.getName() + "WHERE " 
									+ Airport.class.getName() + ".id_airport=" + id);
			airports = (ArrayList<Airport>) q.execute();
			tx.commit();
			
		}finally{
			
			if(tx.isActive()){
				
				tx.rollback();
			}
			pm.close();
		}
		
		return airports.get(0);
	}

	// Je comprends rien à cette fonction
	public String putAirport(Airport Airport, String id) {
		// TODO Auto-generated method stub
		//return "success";
		return "failbro";
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Airport> getAllAirport() {

		ArrayList<Airport> airports = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{
			
			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + Airport.class.getName());
			airports = (ArrayList<Airport>) q.execute();
			tx.commit();
			
		}finally{
			
			if(tx.isActive()){
				
				tx.rollback();
			}
			pm.close();
		}
		
		return airports;
	}

	public String deleteAirport(String id) {
		// TODO Auto-generated method stub
		
		return "success";
		//return "failbro";
	}

	// Pas clair
	public void modifyAirport(String id, Airport Airport) {
		// TODO Auto-generated method stub
		
	}
	
	
=======
import com.g4.dao.AirportDao;

public class AirportPlug implements AirportDao{

>>>>>>> 7d53fb47e5629b5cfab22c2f2378cead8f923edd
}
