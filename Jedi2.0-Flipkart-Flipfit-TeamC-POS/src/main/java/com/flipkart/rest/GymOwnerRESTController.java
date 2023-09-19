/**
 * 
 */
package com.flipkart.rest;

import com.flipkart.bean.Gym;
import com.flipkart.bean.TimeSlot;
import com.flipkart.business.GymOwnerServiceOperation;
import com.flipkart.business.GymServiceOperation;
import com.flipkart.business.NotificationServiceOperation;
import com.flipkart.business.TimeSlotOperation;
import com.flipkart.constants.Constants;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author karan.k2
 */
@Path("/gymowner")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerRESTController {

	/**
	 * Adds a new Gyms
	 * @param gym
	 * @return string
	 */
	@POST
	@Path("/addNewGym")
	public Response addNewGym(final Gym gym) {
		try {
			return Response.ok(GymOwnerServiceOperation.getInstance().addGymCentre(gym)).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	/**
	 * Gets all the notifications for the user
	 * @param id
	 * @return notification list 
	 */
	@GET
	@Path("/notifications/{id}/")
	public Response getNotifications(@PathParam("id") Integer id) {
		try {
		return Response.ok(NotificationServiceOperation.getInstance().viewMyNotifications(id,Constants.ROLE_GYMOWNER)).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}

	/**
	 * Gets registered gyms for id
	 * @param id
	 * @return list of gyms
	 */
	@GET
	@Path("/getRegisteredGyms/{id}")
	public Response getRegisteredGyms(@PathParam("id") Integer id) {
		try {
			return Response.ok(GymOwnerServiceOperation.getInstance().getRegisteredGyms(id)).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	/**
	 * Adds a time slot for a gym
	 * @param slot
	 * @return string
	 */
	@POST
	@Path("/addGymSlot")
	public Response addGymSlot(final TimeSlot slot) {
		try {
			return Response.ok(TimeSlotOperation.getInstance().addSlot(slot)).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	/**
	 * gets user profile
	 * @param id
	 * @return user
	 */
	@GET
	@Path("/profile/{id}")
	public Response getProfile(@PathParam("id") Integer id) {
		try {
			return Response.ok(GymOwnerServiceOperation.getInstance().getGymOwnerById(id)).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	/**
	 * Gets list of all the available gyms
	 * @return list of all the available gyms
	 */
	@GET
	@Path("/getAvailableGyms")
	public Response getAvailableGyms() {
		try {
			return Response.ok(GymServiceOperation.getInstance().viewGymList()).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
}
