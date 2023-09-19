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
		try {
			return Response.ok(GymServiceOperation.getInstance().viewGymList()).build();
	}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}

	public Response bookASlot() {
		try {
			return Response.ok().build();
	}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}
<<<<<<< Updated upstream
	@GET
	@Path("/cancelBooking/{slotId}/{userId}")
	public Response cancelBooking(@PathParam("slotId") Integer slotId, @PathParam("userId") Integer userId) {
		return Response.ok(CustomerServiceOperation.getInstance().cancelSlotByID(slotId, userId)).build();
	}
	
	@GET
	@Path("/getBookings/{id}")
	public Response getBookings(@PathParam("id") Integer id) {
		return Response.ok(BookingServiceOperation.getInstance().viewBookings(id)).build();
=======

	public Response cancelBooking() {
		try {
		return Response.ok().build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}

	public Response getBookings() {
		try {
		return Response.ok().build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
>>>>>>> Stashed changes
	}
	
	@GET
	@Path("/{id}")
	public Response getProfile(@PathParam("id") Integer id) {
<<<<<<< Updated upstream
		return Response.ok(CustomerServiceOperation.getInstance().getProfilebyID(id)).build();
	}
	
	public static void main(String args[]) {
		System.out.println(CustomerServiceOperation.getInstance().cancelSlotByID(12, 18));
=======
		return Response.ok().build();
		
>>>>>>> Stashed changes
	}
}
