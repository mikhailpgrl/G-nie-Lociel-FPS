package com.g4.dao.datanucleus;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Aircraft;
import com.g4.beans.Airport;
import com.g4.dao.AirportDao;

public class AirportDaoImp implements AirportDao {

	public List<Airport> getAllAirport() {
		// TODO Auto-generated method stub
		List<Airport> airport = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			Query q = pm.newQuery(Airport.class);
			airport = (List<Airport>) q.execute();
			tx.commit();

		} finally {

			if (tx.isActive()) {

				tx.rollback();
			}
			pm.close();
		}

		if (airport.isEmpty())
			return null;
		else
			return airport;
	}

	public String deleteAirport(String id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {

			tx.begin();
			Query q = pm.newQuery(Airport.class);
			q.setFilter("id == airportId ");
			q.declareParameters("int airportId");
			q.deletePersistentAll(Integer.parseInt(id));
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
		}

		return "succes";

	}

	public String putAirport(Airport airport) {
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(airport);
			tx.commit();

		} finally {

			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return "success";
	}

}
