package com.g4.dao;

import java.util.ArrayList;

import com.g4.beans.Flight;

public interface FlightDao {

	public Flight getFlight(String id);

	public ArrayList<Flight> getAllFlight();
	
	public String putFlight(Flight flight, String id);

	public String deleteFlight(String id);

	public void modifyFlight(String id, Flight flight);
	
	ArrayList<Flight> getByCriteria(String sort, String value);

}
