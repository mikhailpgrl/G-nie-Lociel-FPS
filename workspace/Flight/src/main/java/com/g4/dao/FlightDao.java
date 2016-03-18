package com.g4.dao;

import java.util.ArrayList;
import java.util.List;

import com.g4.beans.Flight;
import com.g4.utils.Criteria;

public interface FlightDao {

	public Flight getFlight(String id);

	List<Flight> getAllFlight();
	
	public String putFlight(Flight flight, String id);

	public String deleteFlight(String id);

	void modifyFlight(String id, Flight flight);

	List<Flight> getByCriteria(Criteria criteria, String value);
	
	ArrayList<Flight> getByCriteria(String sort, String value);

}
