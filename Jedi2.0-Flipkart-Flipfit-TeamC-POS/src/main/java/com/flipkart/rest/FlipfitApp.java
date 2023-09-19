/**
 * 
 */
package com.flipkart.rest;

import io.dropwizard.core.Application;
import io.dropwizard.core.Configuration;
import io.dropwizard.core.setup.Environment;

/**
 * 
 */
public class FlipfitApp extends Application<Configuration> {

	/**
	 * @author avantika.kala
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new FlipfitApp().run(args);
	}

	@Override
	public void run(Configuration arg0, Environment e) throws Exception {
		e.jersey().register(new AdminRESTController());
		e.jersey().register(new GymOwnerRESTController());
		e.jersey().register(new CustomerRESTController());
		e.jersey().register(new UserRESTController());
		//e.healthChecks().register("application", new ApplicationHealthCheck());
		
	}

}
