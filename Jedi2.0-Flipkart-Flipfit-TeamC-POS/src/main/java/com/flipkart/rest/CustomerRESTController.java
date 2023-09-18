/**
 * 
 */
package com.flipkart.rest;

import com.flipkart.business.GymServiceOperation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author
 */
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerRESTController {

	@GET
	@Path("/getAvailableGyms")
	public Response getAvailableGyms() {
		return Response.ok(GymServiceOperation.getInstance().viewGymList()).build();
	}

	public Response bookASlot() {
		return Response.ok().build();
	}

	public Response cancelBooking() {
		return Response.ok().build();
	}

	public Response getBookings() {
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}")
	public Response getProfile(@PathParam("id") Integer id) {
		return null;
	}
}
