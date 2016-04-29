package com.g4.dao;

import java.util.List;

import com.g4.beans.Leaflet;

public interface LeafletDao {

	List<Leaflet> getAllLeaflet();

	String putLeaflet(Leaflet leaflet);

	String deleteLeaflet(String id);

	Leaflet getLeaflet(String id);

}
