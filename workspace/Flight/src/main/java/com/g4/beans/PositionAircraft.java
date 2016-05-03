package com.g4.beans;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class PositionAircraft {

	
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@PrimaryKey
	private int id;
	private String id_airport;
	private String id_aircraft;
	private String id_flight;
	private String position_date;
	private String position_time;
	
	public PositionAircraft(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_airport() {
		return id_airport;
	}

	public void setId_airport(String id_airport) {
		this.id_airport = id_airport;
	}

	public String getId_aircraft() {
		return id_aircraft;
	}

	public void setId_aircraft(String id_aircraft) {
		this.id_aircraft = id_aircraft;
	}

	public String getPosition_date() {
		return position_date;
	}

	public void setPosition_date(String position_date) {
		this.position_date = position_date;
	}

	public String getPosition_time() {
		return position_time;
	}

	public void setPosition_time(String position_time) {
		this.position_time = position_time;
	}

	public String getId_flight() {
		return id_flight;
	}

	public void setId_flight(String id_flight) {
		this.id_flight = id_flight;
	}
	
	
}
