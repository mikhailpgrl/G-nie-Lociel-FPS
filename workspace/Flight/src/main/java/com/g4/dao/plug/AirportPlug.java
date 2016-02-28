package com.g4.dao.plug;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.dao.AirportDao;
import com.g4.beans.Airport;

public class AirportPlug implements AirportDao{

	public AirportPlug(){

		putAirport(new Airport("TLFPO","Aéroport d'Orly","Paris","France"),"1");
		putAirport(new Airport("EGLL","Aéroport de Londres-Heathrow","Londres",
								"Royaume-Uni"),"2");
	}


	private String addAirport(String icao, String name, String city, String country){

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

	@SuppressWarnings("unchecked")
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

	// A quoi set l'id içi ?
	public String putAirport(Airport airport, String id) {

		return addAirport(airport.getIcao_code(),airport.getAirport_name(),airport.getCity(),
				   airport.getCountry());
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
}
