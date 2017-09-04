package controllers;


import javax.ws.rs.GET;
import javax.ws.rs.*;

@Path("/netid")
public class NetIDController {

    @GET
    public String getNetID(){
        return "fk257";
    }
}
