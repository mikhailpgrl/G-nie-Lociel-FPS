package com.g4.beans;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
<<<<<<< HEAD
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
=======
>>>>>>> 7dbf05ef84452a22ad3fc0f8dd905b599a1d4bc8
@PersistenceCapable
public class Airport {

	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@PrimaryKey
	private int id;
	private String icao_code;
	private String name;
	private String city;
	private String country;

	public Airport(){

	}

	public Airport(String icao, String name, String city, String country){

		this.icao_code = icao;
		this.name = name;
		this.city = city;
		this.country = country;
	}

	public String getIcao_code() {
		return icao_code;
	}

	public void setIcao_code(String icao_code) {
		this.icao_code = icao_code;
	}

	public String getAirport_name() {
		return name;
	}

	public void setAirport_name(String airport_name) {
		this.name = airport_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

<<<<<<< HEAD
	public int getId() {
		return id;
	}

	public void setId(int id) {
=======
	public String getId() {
		return id;
	}

	public void setId(String id) {
>>>>>>> 7dbf05ef84452a22ad3fc0f8dd905b599a1d4bc8
		this.id = id;
	}

}