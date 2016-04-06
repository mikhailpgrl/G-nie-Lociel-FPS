package com.g4.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.g4.dao.datanucleus.FlightDaoImp;
import com.g4.dao.datanucleus.LeafletDaoImpl;
import com.g4.dao.datanucleus.UserDaoImpl;
import com.g4.dao.plug.*;

public class DAO {

	public final static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Flight");
	
	public static FlightDao getFlightDao(){
		return new FlightDaoImp(pmf);
	}

	public static LeafletDao getLeafletDao(){
		return new LeafletDaoImpl(pmf);
	}

	public static UserDao getUserDao(){
		return new UserDaoImpl(pmf);
	}

	public static AirportDao getAirportDao(){
		return new AirportPlug();
	}
}
