package com.falcon.wolf.resource;

import com.falcon.wolf.dto.CustomerDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/wolf/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CustomerResource {

    @GET
    @Path("/hello")
    String sayHello();

    @POST
    @Path("/save")
    void saveCustomer(CustomerDTO customerDTO);
}
