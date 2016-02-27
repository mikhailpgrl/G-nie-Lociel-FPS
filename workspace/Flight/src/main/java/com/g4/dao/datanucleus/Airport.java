package com.g4.dao.datanucleus;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable(table="Airport")
public class Airport {

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
	
}
