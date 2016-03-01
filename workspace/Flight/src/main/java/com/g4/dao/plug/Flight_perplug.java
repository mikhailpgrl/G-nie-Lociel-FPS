package com.g4.dao.plug;

import com.g4.beans.Flight_per;
import com.g4.dao.Flight_perDao;

public class Flight_perplug implements Flight_perDao {
	
	Flight_per fl=new Flight_per(0, null, 0, 0);

	public int getcommercial_number() {
		// TODO Auto-generated method stub
		
		return fl.getcommercial_number();
	}

	public Flight_per createcommercial_number() {
		// TODO Auto-generated method stub
		return new Flight_per(0, null, 0, 0);
	}

	public String getairport_departur() {
		// TODO Auto-generated method stub
		return fl.getdeparture_airport();
	}

	public int getairport_date() {
		// TODO Auto-generated method stub
		return fl.getdeparture_date();
	}
	public Flight_per addflight_per(int  user_id,String departur_airport,int  departure_date,int commercial_number)
	{
		return new Flight_per( user_id, departur_airport,  departure_date, commercial_number);
	}


}
