package com.g4.dao.plug;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Airport;
import com.g4.beans.Flight;
import com.g4.dao.FlightDao;

public class FlightPlug implements FlightDao{

	public FlightPlug(){

		putFlight(new Flight("TVF1234","T012C",
				  new Airport("TLFPO","Aéroport d'Orly","Paris","France"),
				  new Airport("EGLL","Aéroport de Londres-Heathrow","Londres",
		  								"Royaume-Uni"),"2016-04-09",
				  "2016-04-09","16:02:25","16:20:00"),"1");
	}

	@SuppressWarnings("unchecked")
	public Flight getFlight(String id) {

		ArrayList<Flight> flights = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{

			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + Flight.class.getName());
			flights = (ArrayList<Flight>) q.execute();
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}

		if(flights == null)
			return null;

		return flights.get(0);
	}

	public String putFlight(Flight flight, String id) {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		// Update the persistence Manager
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();

		// Relationship between the flight and the airports
		try{

			tx.begin();
			// Create a new flight
			Flight fl = new Flight(flight.getCommercialNumber(),
								   flight.getATC(),
								   flight.getDepartureAirport(),
								   flight.getDArrivalAirport(),
								   flight.getDepartureDate(),
								   flight.getArrivalDate(),
								   flight.getDepartureHour(),
								   flight.getArrivalHour());
			pm.makePersistent(fl);
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}
		
		return "TODO";
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Flight> getAllFlight() {

		ArrayList<Flight> flights = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{

			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + Flight.class.getName());
			flights = (ArrayList<Flight>) q.execute();
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}

		return flights;
	}

	public ArrayList<Flight> getFlightByATC(String atc)
	{
		ArrayList<Flight> flights = getAllFlight();
		ArrayList<Flight> flights_with_atc = new ArrayList<>();
		
		for(int i = 0; i < flights.size(); i++){
			
			if(flights.get(i).getATC().equalsIgnoreCase(atc)){
				
				flights_with_atc.add(flights.get(i));
			}
		}
		
		return flights_with_atc;
	}
	
	
	public String deleteFlight(String id) {
		// TODO Auto-generated method stub
		return "TODO";
	}

	public void modifyFlight(String id, Flight flight) {
		// TODO Auto-generated method stub
	}

}
