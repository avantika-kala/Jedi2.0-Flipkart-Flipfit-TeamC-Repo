package com.flipkart.rest;

import com.flipkart.business.AdminServiceOperation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
		return Response.ok(AdminServiceOperation.getInstance().getPendingGymOwnerRequests()).build();
	}

	public Response handleGymRegistrationRequest(int gymId, int status) {
		return null;
		// TODO
	}

	
	@GET
	@Path("/approveAllGymOwners")
	public Response approveAllGymOwners() {
		return Response.ok(AdminServiceOperation.getInstance().approveAllGymOwners()).build();
	}

	@GET
	@Path("/getPendingGymRegistrationRequests")
	public Response getPendingGymRegistrationRequests() {
		return Response.ok(AdminServiceOperation.getInstance().getPendingGymRegistrationRequests()).build();
	}

	public Response handleGymOwnerRequest(int gymOwnerId, int status) {
		return null;

	}
	
	@GET
	@Path("/approveAllGymRegistrationRequests")
	public Response approveAllGymRegistrationRequests() {
		return Response.ok(AdminServiceOperation.getInstance().approveAllGymRegistrationRequests()).build();

	}

}
