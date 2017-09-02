package controllers;


import javax.ws.rs.GET;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/netid")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class NetIDController {

    @GET
    public String getNetID(){
        return "fk257";
    }
}
