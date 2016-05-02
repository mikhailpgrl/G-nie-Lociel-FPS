package com.g4.utils.quartz;

<<<<<<< HEAD
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
=======
>>>>>>> 7dbf05ef84452a22ad3fc0f8dd905b599a1d4bc8
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.g4.beans.Flight;
import com.g4.dao.DAO;
import com.g4.dao.FlightDao;
<<<<<<< HEAD
import com.g4.utils.email.Email;
=======
>>>>>>> 7dbf05ef84452a22ad3fc0f8dd905b599a1d4bc8

public class CronJob implements Job {
	
	private static FlightDao fd =  DAO.getFlightDao(); ;

<<<<<<< HEAD
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private final static Long oneweek =  (long) 604800000;
	private final static Long twelveHours =  (long) 43200000;
	

=======
>>>>>>> 7dbf05ef84452a22ad3fc0f8dd905b599a1d4bc8
	public void execute(JobExecutionContext arg0) throws JobExecutionException{
		System.out.println("test : " + new Date());
		// tache cron
		List<Flight> lf = fd.getAllFlight();
<<<<<<< HEAD
		List<Flight> lfCrew = new ArrayList<Flight>();
		List<Flight> lfofp = new ArrayList<Flight>();
		String time;
		Date currentDate = new Date();
		Date flightDate = new Date();
		for (Flight flight : lf) {
			time = flight.getDeparture_date() + " " +flight.getArrival_time();
			try {
				flightDate = formatter.parse(time);
				if ((flightDate.getTime() - currentDate.getTime()) < oneweek){
					if (!flight.getId_pilote().equals(null) || !flight.getId_co_pilote().equals(null) ||
							!flight.getId_stewart_un().equals(null) || !flight.getId_stewart_deux().equals(null)||
							!flight.getId_stewart_trois().equals(null) || !flight.getId_aircraft().equals(null)) {
						lfCrew.add(flight);
						
					}
					if ((flightDate.getTime() - currentDate.getTime()) < oneweek){
						
						if (!flight.getOfp().equals(null)){
							lfofp.add(flight);
						}
					}
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!lfCrew.isEmpty()){
			Email.sendEmailCrew(lfCrew);
		}
		if (!lfofp.isEmpty()){
			Email.sendEmailOfp(lfofp);
			
		}
=======
		for (Flight flight : lf) {
			
			if (!flight.getAtc_number().equals(null)) {
				
			}
			
			if (!flight.getArrival_airport().equals(null)) {
				
			}
			
			if (!flight.getArrival_date().equals(null)) {
				
			}
			
			if (!flight.getArrival_airport().equals(null)) {
				
			}
			
			if (!flight.getArrival_airport().equals(null)) {
				
			}
			
			if (!flight.getArrival_airport().equals(null)) {
				
			}
			
			if (!flight.getArrival_airport().equals(null)) {
				
			}
			
			if (!flight.getArrival_airport().equals(null)) {
				
			}
			
			if (!flight.getArrival_airport().equals(null)) {
				
			}
			
			if (!flight.getArrival_airport().equals(null)) {
				
			}
			
			if (!flight.getArrival_airport().equals(null)) {
				
			}
			
			if (!flight.getArrival_airport().equals(null)) {
				
			}
			
		}
		
		
>>>>>>> 7dbf05ef84452a22ad3fc0f8dd905b599a1d4bc8
	}
	
}
