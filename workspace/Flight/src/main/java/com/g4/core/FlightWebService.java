package com.g4.core;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.g4.beans.Flight;
import com.g4.dao.FlightDao;
import com.g4.dao.FlightPlug;
import com.g4.utils.JSonMaker;

@Path("/{a:aircrew|cco}/flight")
public class FlightWebService {

	private static FlightDao fd;
	
	public FlightWebService() {
		// TODO Auto-generated constructor stub
		fd = new FlightPlug();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-flight")
	public Response getFlight(){
		Flight f;
		f = fd.getFlight();
		return Response.status(200).entity(JSonMaker.getJson(f)).build();
	}
	

}