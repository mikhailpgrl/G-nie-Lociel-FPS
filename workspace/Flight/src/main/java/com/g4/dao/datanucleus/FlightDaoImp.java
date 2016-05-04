package com.g4.dao.datanucleus;

import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Flight;
import com.g4.dao.FlightDao;
import com.g4.utils.Criteria;

public class FlightDaoImp implements FlightDao{

	
	public FlightDaoImp(){
		
	}
	
	public Flight getFlight(String id) {
		// TODO Auto-generated method stub
		List<Flight> flights = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
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
		// TODO Auto-generated method stub
		List<Flight> flights = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
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

	public String putFlight(Flight flight) {
		// TODO Auto-generated method stub
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		
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
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		List<Flight> lf = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
		    
		    tx.begin();
		    
		    Query q = pm.newQuery(Flight.class);
			q.setFilter("id == flightId ");
			q.declareParameters("int flightId");
			q.deletePersistentAll(Integer.parseInt(id));
			
		    tx.commit();
		}
		catch (Exception e)
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		}
		
			return "succes";
	}

	public void modifyFlight(String id, Flight flight) {
		// TODO Auto-generated method stub
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
		    
			tx.begin();	

			 Extent e = (Extent) pm.getExtent(Flight.class, true);
		    Iterator iter=(Iterator) e.iterator();
		    while (iter.hasNext())
		    {
		    	 Flight my_obj=(Flight)iter.next();
		    	 if (my_obj.getId() == Integer.parseInt(id) ){
					my_obj.setCommercial_number(flight.getCommercial_number());
					my_obj.setAtc_number(flight.getAtc_number());
					my_obj.setDeparture_date(flight.getDeparture_date());
					my_obj.setArrival_date(flight.getArrival_date());
					my_obj.setDeparture_time(flight.getDeparture_time());
					my_obj.setArrival_time(flight.getArrival_time());
					my_obj.setDeparture_airport(flight.getDeparture_airport());
					my_obj.setArrival_airport(flight.getArrival_airport());
					my_obj.setNotam(flight.getNotam());
					my_obj.setOfp(flight.getOfp());
					my_obj.setId_pilote(flight.getId_pilote());
					my_obj.setId_co_pilote(flight.getId_co_pilote());
					my_obj.setId_stewart_un(flight.getId_stewart_un());
					my_obj.setId_stewart_deux(flight.getId_stewart_deux());
					my_obj.setId_stewart_trois(flight.getId_stewart_trois());
					my_obj.setId_aircraft(flight.getId_aircraft());
		    	 }
		    }
		    tx.commit();
		}
		catch (Exception e)
		{
			System.out.println(e);
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		}
	}

	public List<Flight> getByCriteria(Criteria criteria, String value) {
		// TODO Auto-generated method stub
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
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
