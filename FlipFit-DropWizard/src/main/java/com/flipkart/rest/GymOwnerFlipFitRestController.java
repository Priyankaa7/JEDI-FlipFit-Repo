package com.flipkart.rest;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.business.FlipFitGymOwnerInterface;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.business.FlipFitGymInterface;
import com.flipkart.business.FlipFitGymService;
import com.flipkart.rest.model.GymRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gymOwner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymOwnerFlipFitRestController {

    private final FlipFitGymOwnerInterface gymOwnerService = new FlipFitGymOwnerService();
    private final FlipFitGymInterface gymService = new FlipFitGymService();

    @POST
    @Path("/addGym")
    public Response addGym(GymRequest gymRequest) {
        try {
            Gym gym = new Gym();
            gym.setGymName(gymRequest.getGymName());
            gym.setGymAddress(gymRequest.getGymAddress());
            gym.setOwnerId(gymRequest.getOwnerId());
            gym.setSlots(gymRequest.getSlots());

            gymOwnerService.addGymWithSlots(gym);
            return Response.status(Response.Status.CREATED).entity("Gym added successfully").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to add gym").build();
        }
    }

    @GET
    @Path("/gyms/{ownerId}")
    public Response displayGymsByOwnerId(@PathParam("ownerId") String ownerId) {
        List<Gym> gymsList = gymService.getGymsByOwnerId(ownerId);
        if (gymsList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No gyms found for the owner").build();
        }
        return Response.ok(gymsList).build();
    }

    @POST
    @Path("/registerSlots/{gymId}")
    public Response registerTimeSlots(@PathParam("gymId") int gymId, List<Slots> slots) {
        gymOwnerService.addSlots(gymId, slots);
        return Response.ok("Slots registered successfully").build();
    }
    /*@POST
    @Path("/sendProfileForApproval/{ownerId}")
    public Response sendProfileForApproval(@PathParam("ownerId") String ownerId) {
        boolean isSent = gymOwnerService.sendProfileForApproval(ownerId);
        if (isSent) {
            return Response.ok("Profile sent for approval successfully").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to send profile for approval").build();
        }
    }

    @POST
    @Path("/createGymOwner")
    public Response createGymOwner(GymOwner gymOwner) {
        gymOwnerService.createGymOwner(gymOwner);
        return Response.ok("Gym owner created successfully").build();
    }*/
}
