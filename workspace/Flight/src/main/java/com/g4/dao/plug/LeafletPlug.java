package com.g4.dao.plug;

import java.util.ArrayList;
import java.util.Arrays;

import com.g4.beans.Leaflet;
import com.g4.dao.LeafletDao;

public class LeafletPlug implements LeafletDao{

	public ArrayList<Leaflet> getAllLeaflet() {
		// TODO Auto-generated method stub
		return new ArrayList<Leaflet> ((Arrays.asList(new Leaflet("1"),new Leaflet("2"))));
		//return null;
	}

	public String putLeaflet(Leaflet leaflet) {
		// TODO Auto-generated method stub
		return "success";
		// return "failbro";
	}

	public String deleteLeaflet(String id) {
		// TODO Auto-generated method stub
		return "success";
		// return "failbro";
	}

	public Leaflet getLeaflet(String id) {
		// TODO Auto-generated method stub
		
		return new Leaflet("test leaflet");
		//return null;
	}

}
