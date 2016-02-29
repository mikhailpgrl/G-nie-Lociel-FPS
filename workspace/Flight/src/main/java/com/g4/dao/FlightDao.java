package com.g4.dao;

import java.util.ArrayList;
import java.util.List;

import com.g4.beans.Flight;

public interface FlightDao {

	
	Flight getFlight(String id);

	List<Flight> getAllFlight();
	
	String putFlight(Flight flight, String id);

	String deleteFlight(String id);

	void modifyFlight(String id, Flight flight);

	List<Flight> getByCriteria(String criteria, String value);
	
}
