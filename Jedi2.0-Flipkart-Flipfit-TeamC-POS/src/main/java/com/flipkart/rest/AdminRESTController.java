package com.flipkart.rest;

import com.flipkart.business.AdminServiceOperation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

/**
 * @author avantika.kala
 */
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminRESTController {

	@GET
	@Path("/getPendingGymOwnerRequest")
	public Response getPendingGymOwnerApprovals() {
		try
		{
			return Response.ok(AdminServiceOperation.getInstance().getPendingGymOwnerRequests()).build();
		}
		catch(Exception e)
		{
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/handleGymRegistrationRequest")
	public Response handleGymRegistrationRequest(@QueryParam("gymId") Integer gymId,
			@QueryParam("status") Integer status) {
		try {
			return Response.ok(AdminServiceOperation.getInstance().handleGymRegistrationRequest(gymId, status)).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/approveAllGymOwners")
	public Response approveAllGymOwners() {
		try
		{
			return Response.ok(AdminServiceOperation.getInstance().approveAllGymOwners()).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/getPendingGymRegistrationRequests")
	public Response getPendingGymRegistrationRequests() {
		try {
			return Response.ok(AdminServiceOperation.getInstance().getPendingGymRegistrationRequests()).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("/handleGymOwnerRequest")
	public Response handleGymOwnerRequest(@QueryParam("gymId") Integer gymOwnerId,
			@QueryParam("status") Integer status) {
		try
		{
			return Response.ok(AdminServiceOperation.getInstance().handleGymOwnerRequest(gymOwnerId, status)).build();

		}catch(Exception e)
		{
			return Response.serverError().build();
		}

	}

	@GET
	@Path("/approveAllGymRegistrationRequests")
	public Response approveAllGymRegistrationRequests() {
		try
		{
			return Response.ok(AdminServiceOperation.getInstance().approveAllGymRegistrationRequests()).build();

		}catch(Exception e)
		{
			return Response.serverError().build();
		}

	}

}
