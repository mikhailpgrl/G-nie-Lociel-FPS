package com.g4.dao;

import java.util.List;

import com.g4.beans.Aircraft;

public interface AircraftDao {
	
	List<Aircraft> getAllAircraft();

	String deleteAircraft(String id);

	String putAircraft(Aircraft user);
	
	
}