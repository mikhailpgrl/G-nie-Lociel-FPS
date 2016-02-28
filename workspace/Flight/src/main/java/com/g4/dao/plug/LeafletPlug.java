package com.g4.dao.plug;

import java.util.ArrayArrayList;

import com.g4.beans.Leaflet;
import com.g4.dao.LeafletDao;

public class LeafletPlug implements LeafletDao{

	public LeafletPlug(){

		putLeaflet(new Leaflet("notice information, test"));
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Leaflet> getAllLeaflet() {

		ArrayList<Leaflet> leaflets = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{

			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + Leaflet.class.getName());
			leaflets = (ArrayArrayList<Leaflet>) q.execute();
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}

		return leaflets;
	}

	public String putLeaflet(Leaflet leaflet) {
		return add(leaflet.getContent());
	}

	public String deleteLeaflet(String id) {
		// TODO Auto-generated method stub
		return "TODO";
		// return "failbro";
	}

	public Leaflet getLeaflet(String id) {

		ArrayList<Leaflet> leaflets = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{

			tx.begin();
			Query q = pm.newQuery("SELECT FROM" + Leaflet.class.getName()
									+ "WHERE " + Leaflet.class.getName() +
									".id=" + id);
			leaflets = (ArrayArrayList<Leaflet>) q.execute();
			tx.commit();

		}finally{

			if(tx.isActive()){

				tx.rollback();
			}
			pm.close();
		}

		if(leaflets == null)
			return null;

		return leaflets[0];
	}

	private String add(String notice){

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("FlightGL");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try{

			tx.begin();
			Leaflet usr = new Leaflet(notice);
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
}
