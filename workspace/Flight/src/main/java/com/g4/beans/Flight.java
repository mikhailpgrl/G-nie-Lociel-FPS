package com.g4.beans;

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;


@PersistenceCapable(objectIdClass=Flight.FlightPK.class)
public class Flight {

	// Test comments

	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Unique
	private int id;
	@PrimaryKey
	private String commercial_number;
	private String atc_number;
	@PrimaryKey
	private String departure_date;
	private String arrival_date;
	private String departure_time;
	private String arrival_time;
	@PrimaryKey
	private String departure_airport;
	private String arrival_airport;
	private String notam;
	private String ofp;
	
	public void print(){
		System.out.println(commercial_number);
		System.out.println(atc_number);
		System.out.println(departure_date);
		System.out.println(arrival_date);
		System.out.println(departure_airport);
		System.out.println(arrival_airport);
		System.out.println(notam);
		System.out.println(ofp);
	}
	
	public Flight(String string) {
		// TODO Auto-generated constructor stub
		this.atc_number = string;
	}
	
	public Flight(){
		
	}

	public String getCommercialNumber(){

		return commercial_number;
	}

	public String getATC(){

		return atc_number;
	}

	public String getDepartureAirport(){

		return departure_airport;
	}

	public String getDArrivalAirport(){

		return arrival_airport;
	}


	public String getDepartureDate(){

			return departure_date;
	}

	public String getArrivalDate(){

		return arrival_date;
	}


	// Internal class for composite primary key
	public static class FlightPK implements Serializable{

		private static final long serialVersionUID = 1L;
		String commercial_number;
		int departure_airport;
		String departure_date;


		public FlightPK(){

		}

	    public FlightPK(String value) {

	        StringTokenizer token = new StringTokenizer (value, "::");
	        token.nextToken();
	        this.commercial_number = token.nextToken();

	        try{

	        	this.departure_airport = Integer.parseInt(token.nextToken());

	        }catch(NumberFormatException ne){

	        	ne.printStackTrace();
	        }

	        this.departure_date = token.nextToken();
	    }

	    public boolean equals(Object obj)
	    {
	        if (obj == this){
	            return true;
	        }

	        if (!(obj instanceof FlightPK)){
	            return false;
	        }

	        FlightPK c = (FlightPK)obj;

	        return commercial_number.equals(c.commercial_number)
	        		&& departure_airport == c.departure_airport
	        		&& departure_date.equals(c.departure_date);
	    }

	    public int hashCode ()
	    {
	        return this.commercial_number.hashCode()
	        		^ this.departure_airport
	        		^ this.departure_date.hashCode();
	    }

	    public String toString ()
	    {
	        // Give output expected by String constructor
	        return this.getClass().getName() + "::"  + this.commercial_number
	        		+ "::" + this.departure_airport + "::" + this.departure_airport;
	    }

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	
}
