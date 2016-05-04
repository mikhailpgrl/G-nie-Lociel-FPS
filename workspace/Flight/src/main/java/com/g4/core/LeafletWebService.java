package com.g4.core;

import java.io.File;
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

import com.g4.beans.Leaflet;
import com.g4.dao.DAO;
import com.g4.dao.LeafletDao;
import com.g4.utils.JSonMaker;
import com.g4.utils.pdf.FilePdf;

@Path("/cco/leaflet")
public class LeafletWebService {

	private static LeafletDao ld;
	
	public LeafletWebService() {
		// TODO Auto-generated constructor stub
		ld = DAO.getLeafletDao();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-leaflet")
	public Response getAllLeaflet(){
		List<Leaflet> l;
		l = ld.getAllLeaflet();
		return Response.status(200).entity(JSonMaker.getJson(l)).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create-leaflet")
	public Response createLeaflet(Leaflet leaflet){
		try {
			String message = ld.putLeaflet(leaflet);
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
	@Path("/show-leaflet")
	public Response deleteLeaflet(@QueryParam("id") String id){
		if (id != null && id.length() > 0){
			Leaflet l = ld.getLeaflet(id);
			if(l != null && l.getUrl() != null)
				FilePdf.deletePDF(l);
			String message = ld.deleteLeaflet(id);
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show-leaflet")
	public Response getLeaflet(@QueryParam("id") String id){
		if (id != null && id.length() > 0){
			Leaflet l = ld.getLeaflet(id);
			if (l == null)
				return Response.status(401).entity("LEAFLET_NOT_FOUND").build();
			else
				return Response.status(200).entity(JSonMaker.getJson(l)).build();
		}else{
			return Response.status(400).entity("LEAFLET_GET_ERROR_MANDATORY").build();
		}
	}
	
}
