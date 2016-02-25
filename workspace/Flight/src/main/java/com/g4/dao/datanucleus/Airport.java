package com.g4.dao.datanucleus;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable
public class Airport {

	@PrimaryKey
	int id_airport;
	@Unique
	String icao_code;
	String name;
	String city;
	String country;
	
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
	
}
