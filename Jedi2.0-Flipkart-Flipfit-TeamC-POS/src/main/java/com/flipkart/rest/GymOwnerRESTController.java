/**
 * 
 */
package com.flipkart.rest;

import com.flipkart.bean.Gym;
import com.flipkart.business.GymOwnerServiceOperation;
import com.flipkart.business.GymServiceOperation;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/gymowner")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerRESTController {
	
	@POST
	@Path("/addNewGym")
	public Response addNewGym(final Gym gym) {
		return Response.ok(GymOwnerServiceOperation.getInstance().addGymCentre(gym)).build();
	}

	@GET
	@Path("/getRegisteredGyms/{id}")
	public Response getRegisteredGyms(@PathParam("id") Integer id) {
		return Response.ok(GymOwnerServiceOperation.getInstance().getRegisteredGyms(id)).build();
	}
	
	public Response addGymSlot() {
		return Response.ok().build();
	}
	
	@GET
	@Path("/profile/{id}")
	public Response getProfile(@PathParam("id") Integer id) {		
		return Response.ok(GymOwnerServiceOperation.getInstance().getGymOwnerById(id)).build();
	}
	@GET
	@Path("/getAvailableGyms")
	public Response getAvailableGyms() {
		return Response.ok(GymServiceOperation.getInstance().viewGymList()).build();
	}
}
