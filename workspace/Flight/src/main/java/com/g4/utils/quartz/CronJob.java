package com.g4.utils.quartz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.g4.beans.Flight;
import com.g4.dao.DAO;
import com.g4.dao.FlightDao;
import com.g4.utils.email.Email;

public class CronJob implements Job {
	
	private static FlightDao fd =  DAO.getFlightDao(); ;

	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private final static Long oneweek =  (long) 604800000;
	private final static Long twelveHours =  (long) 43200000;
	

	public void execute(JobExecutionContext arg0) throws JobExecutionException{
		System.out.println("test : " + new Date());
		// tache cron
		
		List<Flight> lf = fd.getAllFlight();
		List<Flight> lfCrew = new ArrayList<Flight>();
		List<Flight> lfofp = new ArrayList<Flight>();
		String time;
		Date currentDate = new Date();
		Date flightDate = new Date();
		System.out.println(lf.size());
		int i=0;
		for (Flight flight : lf) {
			i++;
			time = flight.getDeparture_date() + " " +flight.getArrival_time();
			try {
				flightDate = formatter.parse(time);
				if ((flightDate.getTime() - currentDate.getTime()) < oneweek){
					flight.print();
					System.out.println("test");
					System.out.println(flight.getId_pilote());
					if (flight.getId_pilote() == null){
						System.out.println("pilote");
					}
					if (flight.getId_pilote()== null || flight.getId_co_pilote()== null ||
							flight.getId_stewart_un()== null || flight.getId_stewart_deux()== null||
							flight.getId_stewart_trois()== null || flight.getId_aircraft()== null) {
						lfCrew.add(flight);
						System.out.println("here");
					}
					System.out.println("zaeazerqqsd");
					if ((flightDate.getTime() - currentDate.getTime()) < twelveHours){
						System.out.println("one");
						if (flight.getOfp() ==null){
							lfofp.add(flight);
						}
					}
					System.out.println("hehehe");
					if (i == lf.size() &&!lfCrew.isEmpty()){
						Email.sendEmailCrew(lfCrew);
					}
					if (i == lf.size() && !lfofp.isEmpty()){
						Email.sendEmailOfp(lfofp);
						
					}
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("eitfhomqjshbfojsqb");
		System.out.println(lfCrew.size());
		System.out.println(lfofp.size());
		if (!lfCrew.isEmpty()){
			Email.sendEmailCrew(lfCrew);
		}
		if (!lfofp.isEmpty()){
			Email.sendEmailOfp(lfofp);
			
		}
	}
	
}
