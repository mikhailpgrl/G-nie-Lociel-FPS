package com.g4.dao.datanucleus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.datanucleus.store.rdbms.query.ForwardQueryResult;

import com.g4.beans.Files;
import com.g4.beans.Flight;
import com.g4.beans.Leaflet;
import com.g4.dao.LeafletDao;

public class LeafletDaoImpl implements LeafletDao{

	
	public LeafletDaoImpl(){
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Leaflet> getAllLeaflet() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		
		List<Leaflet> leaflets = new ArrayList<Leaflet>();
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

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
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
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		List<Leaflet> lf = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
		    
		    tx.begin();
		    Query q = pm.newQuery(Leaflet.class);
			q.setFilter("id == leafletId ");
			q.declareParameters("int leafletId");
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
		
			return "succes ";
	}

	public Leaflet getLeaflet(String id) {
		// TODO Auto-generated method stub
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
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



	public void modifyLeaflet(String id, Leaflet leaflet) {
		// TODO Auto-generated method stub
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
		    
			tx.begin();	

			 Extent e = (Extent) pm.getExtent(Leaflet.class, true);
		    Iterator iter=(Iterator) e.iterator();
		    while (iter.hasNext())
		    {
		    	Leaflet my_obj=(Leaflet)iter.next();
		    	 if (my_obj.getId() == Integer.parseInt(id) ){
						my_obj.setContent(leaflet.getContent());
						my_obj.setUrl(leaflet.getUrl());
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




}
