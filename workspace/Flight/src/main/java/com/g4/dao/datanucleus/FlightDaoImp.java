package com.g4.dao.datanucleus;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Flight;
import com.g4.dao.FlightDao;
import com.g4.utils.Criteria;

@SuppressWarnings("unchecked")
public class FlightDaoImp implements FlightDao{

	private PersistenceManagerFactory pmf;
	
	public FlightDaoImp(){
		
		pmf = PersistenceFactory.getFactory();
	}
	
	public Flight getFlight(String id) {

		List<Flight> flights = null;
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{

			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.setFilter("id == flightId ");
			q.declareParameters("int flightId");
			flights =  (List<Flight>) q.execute(Integer.parseInt(id));
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}

		if(flights.isEmpty())
			return null;
		else
			return flights.get(0);
		
	}

	public List<Flight> getAllFlight() {

		List<Flight> flights = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{

			tx.begin();
			Query q = pm.newQuery(Flight.class);
			flights =  (List<Flight>) q.execute();
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}

		if(flights.isEmpty())
			return null;
		else
			return (List<Flight>)flights;
		
	}

	public String putFlight(Flight flight, String id) {
		
		List<Flight> flights = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			pm.makePersistent(flight);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return "success";

	}

	public String deleteFlight(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void modifyFlight(String id, Flight flight) {
		// TODO Auto-generated method stub
		
	}

	public List<Flight> getByCriteria(Criteria criteria, String value) {

		List<Flight> flights = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.setFilter(criteria.getCriteria() + " == value ");
			q.declareParameters("String value");
			flights =  (List<Flight>) q.execute(value);
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}

		if(flights.isEmpty())
			return null;
		else
			return flights;
		
	}

}
