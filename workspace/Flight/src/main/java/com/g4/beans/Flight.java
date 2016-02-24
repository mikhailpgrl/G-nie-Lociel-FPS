package com.g4.beans;


import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Flight {

	private String commercial_number;
	private String atc_number;
	private String departure_date;
	private String arrival_date;
	private String departure_airport;
	private String arrival_airport;
	private String notam;
	private String ofp;
	
	
	public Flight(String string) {
		// TODO Auto-generated constructor stub
		this.atc_number = string;
	}
	
	public Flight(){
		
	}

	public String getCommercial_number() {
		return commercial_number;
	}

	public void setCommercial_number(String ommercial_number) {
		this.commercial_number = ommercial_number;
	}

	public String getAtc_number() {
		return atc_number;
	}

	public void setAtc_number(String atc_number) {
		this.atc_number = atc_number;
	}

	public String getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}

	public String getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(String arrival_date) {
		this.arrival_date = arrival_date;
	}

	public String getDeparture_airport() {
		return departure_airport;
	}

	public void setDeparture_airport(String departure_airport) {
		this.departure_airport = departure_airport;
	}

	public String getArrival_airport() {
		return arrival_airport;
	}

	public void setArrival_airport(String arrival_airport) {
		this.arrival_airport = arrival_airport;
	}

	public String getNotam() {
		return notam;
	}

	public void setNotam(String notam) {
		this.notam = notam;
	}

	public String getOfp() {
		return ofp;
	}

	public void setOfp(String ofp) {
		this.ofp = ofp;
	}
	
	
	
	
}
