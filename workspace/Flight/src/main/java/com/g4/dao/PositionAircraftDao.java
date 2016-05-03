package com.g4.dao;

import java.util.List;

import com.g4.beans.PositionAircraft;

public interface PositionAircraftDao {
	

	List<PositionAircraft> getAllPositionAircraftById(String id_airport);

	String deletePositionAircraft(String id);

	String putPositionAircraft(PositionAircraft aircraft);

	List<PositionAircraft> getAllPositionAircraft();

}
