package com.g4.dao;

import com.g4.dao.datanucleus.FlightDaoImp;
import com.g4.dao.plug.*;

public class DAO {

	public static FlightDao getFlightDao(){
		return new FlightDaoImp();
	}

	public static LeafletDao getLeafletDao(){
		return new LeafletPlug();
	}

	public static UserDao getUserDao(){
		return new UserPlug();
	}

	public static AirportDao getAirportDao(){
		return new AirportPlug();
	}
}
