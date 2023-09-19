/**
 * 
 */
package com.flipkart.rest;

import com.flipkart.business.UserServiceOperation;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.flipkart.bean.Customer;
import com.flipkart.bean.User;

import jakarta.ws.rs.POST;
/**
 * @author avantika.kala
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class UserRESTController {

	@POST
	@Path("/login")
	public Response login(User user) {
		try {
			return Response.ok(UserServiceOperation.getInstance().login(user.getUserName(), user.getPassword())).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}

	@POST
	@Path("/register")
	public Response getRegisteredGyms(Customer customer) {
		try {
			return Response.ok(UserServiceOperation.getInstance().customerRegistration(customer)).build();
		}catch(Exception e)
		{
			return Response.serverError().build();
		}
	}

}
