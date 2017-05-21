package edu.hm.oauth.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
public class UsersResource {

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUsers() {
        // Copy copy = new Copy(user, book);
        // ServiceStatus result = copyService.addBook(copy);
        return Response.ok("listUsers").build();
    }

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser() {
        // Copy copy = new Copy(user, book);
        // ServiceStatus result = copyService.addBook(copy);
        return Response.ok("baba i dupa").build();
    }

    @POST
    @Path("authenticate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser() {
        // Copy copy = new Copy(user, book);
        // ServiceStatus result = copyService.addBook(copy);
        return Response.ok("baba i dupa").build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser() {
        // Copy copy = new Copy(user, book);
        // ServiceStatus result = copyService.addBook(copy);
        return Response.ok("baba i dupa").build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserData() {
        // Copy copy = new Copy(user, book);
        // ServiceStatus result = copyService.addBook(copy);
        return Response.ok("baba i dupa").build();
    }

}
