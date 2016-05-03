package com.g4.dao.datanucleus;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Aircraft;
import com.g4.beans.PositionAircraft;
import com.g4.dao.PositionAircraftDao;

public class PositionAircraftDaoImp implements PositionAircraftDao {

	public List<PositionAircraft> getAllPositionAircraftById(String id_flight) {
		// TODO Auto-generated method stub
		
		List<PositionAircraft> positionAicraft = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			
			

			tx.begin();
			
			Query q = pm.newQuery(PositionAircraft.class);
			q.setFilter("id_flight == idairport ");
			q.declareParameters("int idairport");
			positionAicraft =  (List<PositionAircraft>) q.execute(Integer.parseInt(id_flight));
			
			tx.commit();

		} finally {

			if (tx.isActive()) {

				tx.rollback();
			}
			pm.close();
		}

		if (positionAicraft.isEmpty())
			return null;
		else
			return positionAicraft;
	}
	
	
	
	public List<PositionAircraft> getAllPositionAircraft() {
		// TODO Auto-generated method stub
		
		List<PositionAircraft> positionAicraft = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			
			

			tx.begin();
			
			Query q = pm.newQuery(PositionAircraft.class);
			positionAicraft =  (List<PositionAircraft>) q.execute();
			
			tx.commit();

		} finally {

			if (tx.isActive()) {

				tx.rollback();
			}
			pm.close();
		}

		if (positionAicraft.isEmpty())
			return null;
		else
			return positionAicraft;
	}
	
	

	public String deletePositionAircraft(String id) {
		// TODO Auto-generated method stub
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {

			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			q.setFilter("id == positionAircraftId ");
			q.declareParameters("int positionAircraftId");
			q.deletePersistentAll(Integer.parseInt(id));
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
		}

		return "succes";
	
	}

	public String putPositionAircraft(PositionAircraft aircraft) {
		// TODO Auto-generated method stub
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

}
