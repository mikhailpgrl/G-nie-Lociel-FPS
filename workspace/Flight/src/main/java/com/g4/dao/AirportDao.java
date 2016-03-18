package com.g4.dao;

import java.util.ArrayList;

import com.g4.beans.Airport;

public interface AirportDao {

	public String putAirport(Airport Airport, String id);

	public ArrayList<Airport> getAllAirport();

	public Airport getAirport(String id);

	public String deleteAirport(String id);

	public void modifyAirport(String id, Airport Airport);
}
