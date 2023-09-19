/**
 * 
 */
package com.flipkart.rest;

import com.flipkart.business.BookingServiceOperation;
import com.flipkart.business.CustomerServiceOperation;
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
	@GET
	@Path("/cancelBooking/{slotId}/{userId}")
	public Response cancelBooking(@PathParam("slotId") Integer slotId, @PathParam("userId") Integer userId) {
		return Response.ok(CustomerServiceOperation.getInstance().cancelSlotByID(slotId, userId)).build();
	}
	
	@GET
	@Path("/getBookings/{id}")
	public Response getBookings(@PathParam("id") Integer id) {
		return Response.ok(BookingServiceOperation.getInstance().viewBookings(id)).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getProfile(@PathParam("id") Integer id) {
		return Response.ok(CustomerServiceOperation.getInstance().getProfilebyID(id)).build();
	}
	
	public static void main(String args[]) {
		System.out.println(CustomerServiceOperation.getInstance().cancelSlotByID(12, 18));
	}
}
