package edu.hm.oauth.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("check")
public class CheckResource {

    @POST
    @Path("{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBook(@PathParam("token")String inputToken) {
        //Copy copy = new Copy(user, book);
        //ServiceStatus result = copyService.addBook(copy);
        //return Response.status(result.getStatus()).entity(result).build();
        return Response.status(Response.Status.OK).build();
    }

}
