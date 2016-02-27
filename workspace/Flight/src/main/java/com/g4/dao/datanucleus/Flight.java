package com.g4.dao.datanucleus;


import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(objectIdClass=FlightPK.class)
public class Flight {

	@PrimaryKey
	String commercial_number;
	String atc_number;
	
	@PrimaryKey
	@ForeignKey(table="Airport")
	Airport departure_airport;
	
	@ForeignKey(table="Airport")
	Airport arrival_airport;
	
	@PrimaryKey
	String departure_date;
	String arrival_date;
	String departure_hour;
	String arrival_hour;
	
	protected Flight(){}
	
	public Flight(String cm, String atc, 
					Airport depart_airport, Airport arriv_airport, 
					String depart_date, String arriv_date, 
					String depart_hour, String arriv_hour){
			
		this.commercial_number = cm;
		this.atc_number = atc;
		this.departure_airport = depart_airport;
		this.arrival_airport = arriv_airport;
		this.departure_date = depart_date;
		this.arrival_date = arriv_date;
		this.departure_hour = depart_hour;
		this.arrival_hour = arriv_hour;
	}
	
	public String getCommercialNumber(){
		
		return commercial_number;
	}
	
	public String getATC(){
		
		return atc_number;
	}
	
	public String getDepartureAirport(){
		
		return departure_airport.getICAO();
	}

	public String getDArrivalAirport(){
		
		return arrival_airport.getICAO();
	}
	
	public String getDepartureDate(){
		
			return departure_date;
	}

	public String getArrivalDate(){
		
		return arrival_date;
	}

	public String getDepartureHour(){
		
		return departure_hour;
	}
	
	public String getArrivalHour(){
		
		return arrival_hour;
	}
	
}




