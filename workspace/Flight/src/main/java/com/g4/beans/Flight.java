package com.g4.beans;

public class Flight {

	private String num_commercial;
	private String ATC;
	private String depart_date;
	private String arr_date;
	private String depart_airport;
	private String arr_airport;
	private String notam;
	private String ofp;
	
	
	public Flight(String string) {
		// TODO Auto-generated constructor stub
		this.ATC = string;
	}
	
	public Flight(){
		
	}
	
	public String getNum_commercial() {
		return num_commercial;
	}
	public void setNum_commercial(String num_commercial) {
		this.num_commercial = num_commercial;
	}
	public String getATC() {
		return ATC;
	}
	public void setATC(String aTC) {
		ATC = aTC;
	}
	public String getDepart_date() {
		return depart_date;
	}
	public void setDepart_date(String depart_date) {
		this.depart_date = depart_date;
	}
	public String getArr_date() {
		return arr_date;
	}
	public void setArr_date(String arr_date) {
		this.arr_date = arr_date;
	}
	public String getDepart_airport() {
		return depart_airport;
	}
	public void setDepart_airport(String depart_airport) {
		this.depart_airport = depart_airport;
	}
	public String getArr_airport() {
		return arr_airport;
	}
	public void setArr_airport(String arr_airport) {
		this.arr_airport = arr_airport;
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