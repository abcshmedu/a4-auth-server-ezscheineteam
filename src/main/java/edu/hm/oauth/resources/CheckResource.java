package edu.hm.oauth.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hm.oauth.business.CheckService;
import edu.hm.oauth.business.CheckServiceImpl;
import edu.hm.oauth.business.ServiceStatus;
import edu.hm.shareit.business.MediaService;
import edu.hm.shareit.business.MediaServiceImpl;

@Path("check")
public class CheckResource {

    private final CheckService checkService = new CheckServiceImpl();
    
    @GET
    @Path("{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkToken(@PathParam("token")String inputToken) {
        ServiceStatus result = 
        //Copy copy = new Copy(user, book);
        //ServiceStatus result = copyService.addBook(copy);
        return Response.ok().build();
    }
}

