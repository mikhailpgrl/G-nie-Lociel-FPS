package com.g4.dao.datanucleus;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Aircraft;
import com.g4.dao.AircraftDao;

public class AircraftDaoImp implements AircraftDao {

	public AircraftDaoImp() {

	}

	public List<Aircraft> getAllAircraft() {
		// TODO Auto-generated method stub
		List<Aircraft> users = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			users = (List<Aircraft>) q.execute();
			tx.commit();

		} finally {

			if (tx.isActive()) {

				tx.rollback();
			}
			pm.close();
		}

		if (users.isEmpty())
			return null;
		else
			return users;
	}

	public String putAircraft(Aircraft aircraft) {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(aircraft);
			tx.commit();

		} finally {

			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return "success";

	}

	public String deleteAircraft(String id) {
		// TODO Auto-generated method stub
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {

			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			q.setFilter("id == aircraftId ");
			q.declareParameters("int aircraftId");
			q.deletePersistentAll(Integer.parseInt(id));
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
		}

		return "succes";
	}

}
