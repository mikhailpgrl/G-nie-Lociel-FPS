package com.g4.dao;

import java.util.ArrayList;
import java.util.Arrays;

import com.g4.beans.Flight;

public class FlightPlug  implements FlightDao{

	public Flight getFlight(String id) {
		// TODO Auto-generated method stub
		return new Flight("tetet�eqf");
		//return null;
	}

	public String putFlight(Flight flight, String id) {
		// TODO Auto-generated method stub
		//return "success";
		return "failbro";
	}


	public ArrayList<Flight> getAllFlight() {
		// TODO Auto-generated method stub
		//return new ArrayList<Flight> ((Arrays.asList(new Flight("tetet�eqf"),new Flight("az"))));
		return null;
	}

	public String deleteFlight(String id) {
		// TODO Auto-generated method stub
		return "success";
		//return "failbro";
	}

	public void modifyFlight(String id, Flight flight) {
		// TODO Auto-generated method stub
		
	}

}