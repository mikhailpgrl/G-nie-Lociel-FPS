package com.g4.dao.plug;

import java.util.ArrayList;
import java.util.Arrays;

import com.g4.beans.Flight;
import com.g4.dao.FlightDao;

public class FlightPlug implements FlightDao{

	public FlightPlug(){

		putFlight(new Flight("TVF1234","T012C",
				  new Airport("TLFPO","Aéroport d'Orly","Paris","France"),
				  new Airport("EGLL","Aéroport de Londres-Heathrow","Londres",
		  								"Royaume-Uni"),"2016-04-09",
				  "2016-04-09","16:02:25","16:20:00"),1);
	}


	public Flight getFlight(String id) {

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

		if(flights == null)
			return null;

		return flights[0];
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
	}

	public ArrayList<Flight> getAllFlight() {

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

	public String deleteFlight(String id) {
		// TODO Auto-generated method stub
		return "TODO";
		//return "failbro";
	}

	public void modifyFlight(String id, Flight flight) {
		// TODO Auto-generated method stub
	}

}
