package com.g4.beans;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable
public class Flight {

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
	private String id_aircraft;
	private String id_pilote;
	private String id_co_pilote;
	private String id_stewart_un;
	private String id_stewart_deux;
	private String id_stewart_trois;

	
	public void print(){
		System.out.println(id);
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

	public String getId_aircraft() {
		return id_aircraft;
	}

	public void setId_aircraft(String id_aircraft) {
		this.id_aircraft = id_aircraft;
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

	public String getId_pilote() {
		return id_pilote;
	}

	public void setId_pilote(String id_pilote) {
		this.id_pilote = id_pilote;
	}

	public String getId_co_pilote() {
		return id_co_pilote;
	}

	public void setId_co_pilote(String id_co_pilote) {
		this.id_co_pilote = id_co_pilote;
	}

	public String getId_stewart_un() {
		return id_stewart_un;
	}

	public void setId_stewart_un(String id_stewart_un) {
		this.id_stewart_un = id_stewart_un;
	}

	public String getId_stewart_deux() {
		return id_stewart_deux;
	}

	public void setId_stewart_deux(String id_stewart_deux) {
		this.id_stewart_deux = id_stewart_deux;
	}

	public String getId_stewart_trois() {
		return id_stewart_trois;
	}

	public void setId_stewart_trois(String id_stewart_trois) {
		this.id_stewart_trois = id_stewart_trois;
	}

	
	
	
	
}
