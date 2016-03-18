package com.g4.dao.plug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.g4.beans.Flight;
import com.g4.dao.FlightDao;
import com.g4.utils.Criteria;

public class FlightPlug implements FlightDao{

	public FlightPlug(){

		/*putFlight(new Flight("TVF1234","T012C",
				  new Airport("TLFPO","Aéroport d'Orly","Paris","France"),
				  new Airport("EGLL","Aéroport de Londres-Heathrow","Londres",
		  								"Royaume-Uni"),"2016-04-09",
				  "2016-04-09","16:02:25","16:20:00"),"1");*/
	}

	@SuppressWarnings("unchecked")
	public Flight getFlight(String id) {

		return null;

	}

	public String putFlight(Flight flight, String id) {

		// TODO Auto-generated method stub
		//return "success";
		return "success";
		//return "failbro";
	}


	public List<Flight> getAllFlight() {
		// TODO Auto-generated method stub
		return new ArrayList<Flight> ((Arrays.asList(new Flight("tetet�eqf"),new Flight("az"))));
		//return null;
	}

	
	public String deleteFlight(String id) {
		// TODO Auto-generated method stub
		return "TODO";
	}

	public void modifyFlight(String id, Flight flight) {
		// TODO Auto-generated method stub
	}

	public List<Flight> getByCriteria(Criteria criteria, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Flight> getByCriteria(String sort, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
