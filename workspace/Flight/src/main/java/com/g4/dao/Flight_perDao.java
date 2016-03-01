package com.g4.dao;

import java.util.ArrayList;

import com.g4.beans.Flight_per;



public interface  Flight_perDao {
	
	int getcommercial_number();
	Flight_per createcommercial_number();
	Flight_per addflight_per(int  user_id,String departur_airport,int  departure_date,int commercial_number);
	String getairport_departur ();
	int getairport_date ();
	

	

}
