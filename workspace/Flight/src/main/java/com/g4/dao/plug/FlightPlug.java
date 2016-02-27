package com.g4.dao.plug;

import java.util.ArrayList;
import java.util.Arrays;

import com.g4.beans.Flight;
import com.g4.dao.FlightDao;

public class FlightPlug  implements FlightDao{

	public Flight getFlight(String id) {
		// TODO Auto-generated method stub
		return new Flight("tetetéeqf");
		//return null;
	}

	public String putFlight(Flight flight, String id) {
		// TODO Auto-generated method stub
		//return "success";
		flight.print();
		return "success";
		//return "failbro";
	}


	public ArrayList<Flight> getAllFlight() {
		// TODO Auto-generated method stub
		return new ArrayList<Flight> ((Arrays.asList(new Flight("tetetéeqf"),new Flight("az"))));
		//return null;
	}

	public String deleteFlight(String id) {
		// TODO Auto-generated method stub
		return "success";
		//return "failbro";
	}

	public void modifyFlight(String id, Flight flight) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Flight> sortFlight(String sort,String value) {
		// TODO Auto-generated method stub
		return null;
		
	}

}
