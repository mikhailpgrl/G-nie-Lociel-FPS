package com.g4.core;

import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.g4.beans.Flight;
import com.g4.beans.Leaflet;
import com.g4.beans.Users;
import com.g4.dao.DAO;
import com.g4.dao.UserDao;
import com.g4.utils.JSonMaker;

@Path("/{a:aircrew|cco}/user")
public class UserWebService {

	private static UserDao ud;

	public UserWebService() {
		// TODO Auto-generated constructor stub
		ud = DAO.getUserDao();
	}

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-user")
	public Response getAllFlight(){
		List<Users> user;
		user = ud.getAllUsers();
		if(user != null && !user.isEmpty())
			for (Users users : user) {
				users.deleteData();
			}
		return Response.status(200).entity(JSonMaker.getJson(user)).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response getUser(@QueryParam("userId") String id, @QueryParam("token") String token) {
		if (id != null && id.length() > 0 && id != null && id.length() > 0) {
			Users u = null;
			u = ud.getUser(id, token);
			if (u == null)
				return Response.status(401).entity("USER_NOT_FOUND").build();
			else
				return Response.status(200).entity(JSonMaker.getJson(u)).build();
		} else {
			return Response.status(400).entity("USER_GET_ERROR_MANDATORY").build();
		}
	}
	
	
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create-user")
	public Response createLeaflet(Users user){
		try {
			String message = ud.putUser(user);
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
	@Path("/delete-user")
	public Response deleteLeaflet(@QueryParam("id") String id){
		if (id != null && id.length() > 0){
			String message = ud.deleteUser(id);
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
