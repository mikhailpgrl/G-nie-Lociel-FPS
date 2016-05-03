package com.g4.dao;

import java.util.List;

import com.g4.beans.Airport;

public interface AirportDao {
	

	List<Airport> getAllAirport();

	String deleteAirport(String id);

	String putAirport(Airport user);
	
	Airport getAirport(String id);
	
}
