package com.g4.dao.datanucleus;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.datanucleus.store.rdbms.query.ForwardQueryResult;

import com.g4.beans.Leaflet;
import com.g4.dao.LeafletDao;

public class LeafletDaoImpl implements LeafletDao{

	private PersistenceManagerFactory pmf;
	
	public LeafletDaoImpl(PersistenceManagerFactory pmf){
		
		this.pmf = pmf;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Leaflet> getAllLeaflet() {
		
		List<Leaflet> leaflets = new ArrayList<Leaflet>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(Leaflet.class);
			leaflets = (ForwardQueryResult) q.execute();
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

	public Leaflet getLeaflet(String id) {
		// TODO Auto-generated method stub
		List<Leaflet> leaflets = new ArrayList<Leaflet>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(Leaflet.class);
			q.setFilter("id == identifier ");
			q.declareParameters("int identifier");
			leaflets =  (List<Leaflet>) q.execute(Integer.parseInt(id));
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
