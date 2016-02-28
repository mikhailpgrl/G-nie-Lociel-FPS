package com.g4.dao;

import java.util.ArrayList;

import com.g4.beans.Flight;
import com.g4.beans.FlightPer;
import com.g4.beans.User;

public interface FlightPerDao {

	public String add(Flight flight, User user);

	public ArrayList<FlightPer> selectAll();
}
