package com.g4.dao.datanucleus;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.g4.beans.Leaflet;
import com.g4.dao.LeafletDao;

public class LeafletDaoImpl implements LeafletDao{

	private PersistenceManagerFactory pmf;
	
	public LeafletDaoImpl(){
		
		pmf = PersistenceFactory.getFactory();
	}
	
	@SuppressWarnings("unchecked")
	public List<Leaflet> getAllLeaflet() {
		
		List<Leaflet> leaflets;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		
		try{

			tx.begin();
			Query q = pm.newQuery(Leaflet.class);
			leaflets = (List<Leaflet>) q.execute();
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}

		if(leaflets.isEmpty())
			return null;
		else
			return leaflets;
		
	}

	public String putLeaflet(Leaflet leaflet) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(leaflet);
			tx.commit();
			
		} finally {
			
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return "success";
		
	}

	public String deleteLeaflet(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public Leaflet getLeaflet(String id) {
		// TODO Auto-generated method stub
		
		List<Leaflet> leaflets;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		
		try{

			tx.begin();
			Query q = pm.newQuery(Leaflet.class);
			q.setFilter("id == identifier ");
			q.declareParameters("String identifier");
			leaflets = (List<Leaflet>) q.execute(id);
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}

		if(leaflets.isEmpty())
			return null;
		else
			return leaflets.get(0);
	}

}
