/**
 * 
 */
package com.flipkart.rest;

import com.flipkart.bean.Gym;
import com.flipkart.bean.TimeSlot;
import com.flipkart.business.GymOwnerServiceOperation;
import com.flipkart.business.GymServiceOperation;
import com.flipkart.business.TimeSlotOperation;

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
		try {
		return Response.ok(GymOwnerServiceOperation.getInstance().addGymCentre(gym)).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/getRegisteredGyms/{id}")
	public Response getRegisteredGyms(@PathParam("id") Integer id) {
		try {
			return Response.ok(GymOwnerServiceOperation.getInstance().getRegisteredGyms(id)).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/addGymSlot")
	public Response addGymSlot(final TimeSlot slot) {
		try {
		return Response.ok(TimeSlotOperation.getInstance().addSlot(slot)).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("/profile/{id}")
	public Response getProfile(@PathParam("id") Integer id) {	
		try {
		return Response.ok(GymOwnerServiceOperation.getInstance().getGymOwnerById(id)).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}
	@GET
	@Path("/getAvailableGyms")
	public Response getAvailableGyms() {
		try {
			return Response.ok(GymServiceOperation.getInstance().viewGymList()).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}
}
