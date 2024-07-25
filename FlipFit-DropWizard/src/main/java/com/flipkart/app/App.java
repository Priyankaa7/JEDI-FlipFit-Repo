package com.flipkart.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.rest.*;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<Configuration> {
    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
        // Initialization logic if needed
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new GymOwnerFlipFitRestController());
        e.jersey().register(new CORSFilter());
        // Register other resources if needed
        // e.jersey().register(new AdminGMSRESTService());
        // e.jersey().register(new GymOwnerGMSRESTService());
        // e.jersey().register(new UserGMSRESTService());
        // e.jersey().register(new CustomerGMSRESTService());
        // e.jersey().register(new EmployeeRESTController(e.getValidator()));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
