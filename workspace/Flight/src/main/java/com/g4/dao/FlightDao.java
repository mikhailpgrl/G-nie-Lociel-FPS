package com.g4.dao;


import java.util.List;

import com.g4.beans.Flight;
import com.g4.utils.Criteria;

public interface FlightDao {

	
	Flight getFlight(String id);

	List<Flight> getAllFlight();
	
	String putFlight(Flight flight);

	String deleteFlight(String id);

	void modifyFlight(String id, Flight flight);

	List<Flight> getByCriteria(Criteria criteria, String value);
	
}
