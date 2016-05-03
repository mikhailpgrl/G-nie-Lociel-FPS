package com.g4.core;

import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.g4.beans.PositionAircraft;
import com.g4.dao.DAO;
import com.g4.dao.PositionAircraftDao;
import com.g4.utils.JSonMaker;

@Path("/{a:aircrew|cco}/position")
public class PositionAircraftWebService {

	private static PositionAircraftDao pad;

	public PositionAircraftWebService() {
		// TODO Auto-generated constructor stub
		pad = DAO.getPositionAircraftDao();
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/position")
	public Response getAllPosition(){
		List<PositionAircraft> positionAircraft;
		positionAircraft = pad.getAllPositionAircraft();
		return Response.status(200).entity(JSonMaker.getJson(positionAircraft)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/position-id")
	public Response getAllPositionById(@QueryParam("id")String id){
		List<PositionAircraft> positionAircraft;
		positionAircraft = pad.getAllPositionAircraftById(id);
		return Response.status(200).entity(JSonMaker.getJson(positionAircraft)).build();
	}
	
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create-position")
	public Response createLeaflet(PositionAircraft position){
		try {
			String message = pad.putPositionAircraft(position);
			if (message.contains("success")) {
				return Response.status(200).entity(message).build();
			} else {
				return Response.status(400).entity(message).build();
			}
		} catch (JDODataStoreException e) {
			// TODO: handle exception
			return Response.status(500).entity("Error : Already in database").build();
		}
			
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete-position")
	public Response deleteLeaflet(@QueryParam("id") String id){
		if (id != null && id.length() > 0){
			String message = pad.deletePositionAircraft(id);
			if (message.contains("succes")){
				return Response.status(200).entity(message).build();
			}
			else{
				return Response.status(400).entity(message).build();
			}
			
		}else{
			return Response.status(400).entity("LEAFLET_ID_MANDATORY").build();
		}	
	}
	
	
	

}
