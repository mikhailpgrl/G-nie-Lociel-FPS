package com.g4.core;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.g4.dao.LeafletDao;
import com.g4.dao.LeafletPlug;

@Path("/cco/flight")
public class LeafletWebService {

	private static LeafletDao ld;
	
	public LeafletWebService() {
		// TODO Auto-generated constructor stub
		ld = new LeafletPlug();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-leaflet")
	public Response getAllLeaflet(){
		return null;
	}
	
}
