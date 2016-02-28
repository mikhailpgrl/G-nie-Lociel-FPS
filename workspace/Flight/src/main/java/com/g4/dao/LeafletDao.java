package com.g4.dao;

import java.util.ArrayList;

import com.g4.beans.Leaflet;

public interface LeafletDao {

	public ArrayList<Leaflet> getAllLeaflet();

	public String putLeaflet(Leaflet leaflet);

	public String deleteLeaflet(String id);

	public Leaflet getLeaflet(String id);

}
