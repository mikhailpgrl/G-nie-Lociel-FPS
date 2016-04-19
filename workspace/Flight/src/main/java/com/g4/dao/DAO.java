package com.g4.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.g4.dao.datanucleus.FlightDaoImp;
import com.g4.dao.datanucleus.LeafletDaoImpl;
import com.g4.dao.datanucleus.UserDaoImpl;
import com.g4.dao.plug.*;

public class DAO {

	
	public static FlightDao getFlightDao(){
		return new FlightDaoImp();
	}

	public static LeafletDao getLeafletDao(){
		return new LeafletDaoImpl();
	}

	public static UserDao getUserDao(){
		return new UserDaoImpl();
	}

	public static AirportDao getAirportDao(){
		return new AirportPlug();
	}
}
