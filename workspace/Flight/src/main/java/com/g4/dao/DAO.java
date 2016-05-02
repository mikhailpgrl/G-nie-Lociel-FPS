package com.g4.dao;

import com.g4.dao.datanucleus.FlightDaoImp;
import com.g4.dao.datanucleus.LeafletDaoImpl;
import com.g4.dao.datanucleus.UserDaoImpl;
<<<<<<< HEAD
import com.g4.dao.datanucleus.AircraftDaoImp;
import com.g4.dao.datanucleus.AirportDaoImp;
import com.g4.dao.datanucleus.PositionAircraftDaoImp;
=======
import com.g4.dao.plug.AirportPlug;
>>>>>>> 7dbf05ef84452a22ad3fc0f8dd905b599a1d4bc8

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
		return new AirportDaoImp();
	}
	
	public static AircraftDao getAircraftDao(){
		return new AircraftDaoImp();
	}
	
	public static PositionAircraftDao getPositionAircraftDao(){
		return new PositionAircraftDaoImp();
	}
}
