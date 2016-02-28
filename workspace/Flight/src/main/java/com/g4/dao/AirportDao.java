package com.g4.dao;

public interface AirportDao {

	public String putAirport(Airport Airport, String id);

	public String addAirport(String icao, String name, String city, String country);

	public ArrayList<Airport> getAllAirport();

	public Airport getAirport(String id)

	public String deleteAirport(String id);

	public void modifyAirport(String id, Airport Airport);
}
