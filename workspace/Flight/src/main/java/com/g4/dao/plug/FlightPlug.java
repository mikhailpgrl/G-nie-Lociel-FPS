package com.g4.dao.plug;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Flight;
import com.g4.dao.FlightDao;

public class FlightPlug implements FlightDao{

	public FlightPlug(){

		/*putFlight(new Flight("TVF1234","T012C",
				  new Airport("TLFPO","Aéroport d'Orly","Paris","France"),
				  new Airport("EGLL","Aéroport de Londres-Heathrow","Londres",
		  								"Royaume-Uni"),"2016-04-09",
				  "2016-04-09","16:02:25","16:20:00"),"1");*/
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
			Flight fl = new Flight(flight.getCommercial_number(),
								   flight.getAtc_number(),
								   flight.getDeparture_airport(),
								   flight.getArrival_airport(),
								   flight.getDeparture_date(),
								   flight.getArrival_date(),
								   flight.getDep_time(),
								   flight.getArr_time(),flight.getNotam(),
								   flight.getOfp());
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
	
	
	public String deleteFlight(String id) {
		// TODO Auto-generated method stub
		return "TODO";
	}

	public void modifyFlight(String id, Flight flight) {
		// TODO Auto-generated method stub
	}

	
	public ArrayList<Flight> getByCriteria(String criteria,String value) {

		System.out.println(criteria + "  " + value);
		

		if(criteria == "ATC"){
			return getByAtc(value);
		}
		if(criteria == "com_number"){
			return getByComNumber(value);
		}
		if(criteria == "dep_airport"){
			return getByDepAirport(value);
		}
		if(criteria == "arr_airport"){
			return getByArrairport(value);
		}
		if(criteria == "dep_date"){
			return getByDepDate(value);
		}
		if(criteria == "arr_date"){
			return getByArrDate(value);
		}else{
			return null;
		}       
        
    }
	
	
	// A implementer à partir d'ici
	
	private ArrayList<Flight> getByAtc(String atc){
		
		ArrayList<Flight> flights = getAllFlight();
		ArrayList<Flight> flights_with_atc = new ArrayList<>();
		
		for(int i = 0; i < flights.size(); i++){
			
			if(flights.get(i).getAtc_number().equalsIgnoreCase(atc)){
				
				flights_with_atc.add(flights.get(i));
			}
		}
		
		return flights_with_atc;
	}
	
	private ArrayList<Flight> getByComNumber(String commercial_number){
		
		ArrayList<Flight> flights = getAllFlight();
		ArrayList<Flight> flights_with_com = new ArrayList<>();
		
		for(int i = 0; i < flights.size(); i++){
			
			if(flights.get(i).getCommercial_number().equalsIgnoreCase(commercial_number)){
				
				flights_with_com.add(flights.get(i));
			}
		}
		
		return flights_with_com;
	}
	
	private ArrayList<Flight> getByDepAirport(String dep_airport){
		
		ArrayList<Flight> flights = getAllFlight();
		ArrayList<Flight> flights_with_dep = new ArrayList<>();
		
		for(int i = 0; i < flights.size(); i++){
			
			if(flights.get(i).getDeparture_airport().equalsIgnoreCase(dep_airport)){
				
				flights_with_dep.add(flights.get(i));
			}
		}
		
		return flights_with_dep;
	}
	
	private ArrayList<Flight> getByArrairport(String arr_airport){
		
		ArrayList<Flight> flights = getAllFlight();
		ArrayList<Flight> flights_with_arr = new ArrayList<>();
		
		for(int i = 0; i < flights.size(); i++){
			
			if(flights.get(i).getArrival_airport().equalsIgnoreCase(arr_airport)){
				
				flights_with_arr.add(flights.get(i));
			}
		}
		
		return flights_with_arr;
	}
	
	private ArrayList<Flight> getByDepDate(String dep_date){
		
		ArrayList<Flight> flights = getAllFlight();
		ArrayList<Flight> flights_with_date = new ArrayList<>();
		
		for(int i = 0; i < flights.size(); i++){
			
			if(flights.get(i).getDeparture_date().equalsIgnoreCase(dep_date)){
				
				flights_with_date.add(flights.get(i));
			}
		}
		
		return flights_with_date;
	}
	
	private ArrayList<Flight> getByArrDate(String arr_date){
		
		ArrayList<Flight> flights = getAllFlight();
		ArrayList<Flight> flights_with_date = new ArrayList<>();
		
		for(int i = 0; i < flights.size(); i++){
			
			if(flights.get(i).getDeparture_date().equalsIgnoreCase(arr_date)){
				
				flights_with_date.add(flights.get(i));
			}
		}
		
		return flights_with_date;
	}
	
	
}
