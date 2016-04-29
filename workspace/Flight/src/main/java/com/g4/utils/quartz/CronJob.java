package com.g4.utils.quartz;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.g4.beans.Flight;
import com.g4.dao.DAO;
import com.g4.dao.FlightDao;

public class CronJob implements Job {
	
	private static FlightDao fd =  DAO.getFlightDao(); ;

	public void execute(JobExecutionContext arg0) throws JobExecutionException{
		System.out.println("test : " + new Date());
		// tache cron
		List<Flight> lf = fd.getAllFlight();
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
		
		
	}
	
}
