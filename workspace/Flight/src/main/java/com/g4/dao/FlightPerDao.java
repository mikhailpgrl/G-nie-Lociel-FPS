package com.g4.dao;

import java.util.ArrayList;

import com.g4.beans.Flight;
import com.g4.beans.FlightPer;
import com.g4.beans.Users;

public interface FlightPerDao {

	public String add(Flight flight, Users user);

	public ArrayList<FlightPer> selectAll();
}
