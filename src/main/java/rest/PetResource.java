/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.DataFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Hassuni
 */
@Path("pet")
public class PetResource {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    DataFacade df = new DataFacade();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PetResource
     */
    public PetResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PetResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCount() {
       return Response.ok().entity("{\"petCount\":" + gson.toJson(df.getAllPets().size())+ "}").build();
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPets(){
        return Response.ok().entity(gson.toJson(df.getAllPets())).build();
    }
    
    @GET
    @Path("/alive")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allAlivePets(){
        return Response.ok().entity(gson.toJson(df.getAllAlivePets())).build();
    }

    /**
     * PUT method for updating or creating an instance of PetResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
