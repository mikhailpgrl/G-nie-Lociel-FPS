package com.g4.beans;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Airport {

	private String id;
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

}

