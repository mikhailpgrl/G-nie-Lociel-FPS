package com.g4.dao;

import java.util.ArrayList;

import com.g4.beans.Leaflet;

public interface LeafletDao {

	ArrayList<Leaflet> getAllLeaflet();

	String putLeaflet(Leaflet leaflet);

	String deleteLeaflet(String id);

	Leaflet getLeaflet(String id);

}
