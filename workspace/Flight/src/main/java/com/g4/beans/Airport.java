package com.g4.beans;

<<<<<<< HEAD
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable(table="Airport")
=======

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
>>>>>>> 7d53fb47e5629b5cfab22c2f2378cead8f923edd
public class Airport {
	private String icao_code;
	private String airport_name;
	private String city;
	private String country;
	
	public Airport(){
		
	}

	public String getIcao_code() {
		return icao_code;
	}

	public void setIcao_code(String icao_code) {
		this.icao_code = icao_code;
	}

	public String getAirport_name() {
		return airport_name;
	}

	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
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

<<<<<<< HEAD
	@PrimaryKey
	private int id_airport;
	@Unique
	private String icao_code;
	private String name;
	private String city;
	private String country;
	
	protected Airport(){
		
	}
	
	public Airport(String icao, String name, String city, String country){
		
		this.icao_code = icao;
		this.name = name;
		this.city = city;
		this.country = country;
	}
	
	public String getICAO(){
		
		return icao_code;
	}
	
	public String getAirportName(){
		
		return name;
	}
	
	public String getCity(){
		
		return city;
	}
	
	public String getCountry(){
		
		return country;
	}
=======
	public void setCountry(String country) {
		this.country = country;
	}
	
>>>>>>> 7d53fb47e5629b5cfab22c2f2378cead8f923edd
	
}
