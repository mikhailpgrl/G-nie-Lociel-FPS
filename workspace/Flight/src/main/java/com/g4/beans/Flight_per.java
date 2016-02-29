package com.g4.beans;

public class Flight_per {
	private int  user_id; 
	private String departure_airport;
	private int departure_date;
	private int commercial_number;
	
	public Flight_per(int  user_id,String departur_airport,int  departure_date,int commercial_number)
	{
		this.user_id=user_id;
		this.departure_airport=departur_airport;
		this.departure_date=departure_date;
		this.commercial_number=commercial_number;
		
	}
	
	public int  getuser_id()
	{
		return this.user_id;
	}
	public String getdeparture_airport()
	{
		return this.departure_airport;
	}
	public int getdeparture_date()
	{
		return this.departure_date;
	}
	public int getcommercial_number()
	{
		return this.commercial_number;
	}
	
	public void  setuser_id(int user_id)
	{
		 this.user_id=user_id;
	}
	public void setdeparture_airport(String departure_airport)
	{
		this.departure_airport=departure_airport;
	}
	public void setdeparture_date(int departure_date )
	{
		 this.departure_date=departure_date;
	}
	public void  setetcommercial_number(int commercial_number)
	{
		 this.commercial_number=commercial_number;
	}
	
	
}
