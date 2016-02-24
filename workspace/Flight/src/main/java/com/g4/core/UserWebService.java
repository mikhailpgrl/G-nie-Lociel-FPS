package com.g4.core;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.g4.beans.User;
import com.g4.dao.UserDao;
import com.g4.dao.plug.UserPlug;
import com.g4.utils.JSonMaker;

@Path("/{a:aircrew|cco}/user")
public class UserWebService {

	private static UserDao ud;
	
	public UserWebService() {
		// TODO Auto-generated constructor stub
		ud = new UserPlug();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response getUser(@QueryParam("userId") String id, @QueryParam("token") String token,User user){
		if (id != null && id.length() > 0 && id != null && id.length() > 0){
			User u = null;
			//try {
				u = ud.getUser(id,token);
				user.print();
			/*} catch (SQLException e) {
				return  Response.status(500).entity("INTERNAL_ERROR").build();
			}*/
			if (u == null)
				return Response.status(401).entity("USER_NOT_FOUND").build();
			else
				return Response.status(200).entity(JSonMaker.getJson(u)).build();
		}else{
			return Response.status(400).entity("USER_GET_ERROR_MANDATORY").build();
		}
	}
	

	
}
