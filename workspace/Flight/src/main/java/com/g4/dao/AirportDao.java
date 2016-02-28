package com.g4.dao;

public interface AirportDao {

	public String putAirport(Airport Airport, String id);

	public ArrayList<Airport> getAllAirport();

	public Airport getAirport(String id)

	public String deleteAirport(String id);

	public void modifyAirport(String id, Airport Airport);
}
