package edu.hm.oauth.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hm.oauth.business.CheckService;
import edu.hm.oauth.business.CheckServiceImpl;
import edu.hm.oauth.business.ServiceResult;
import edu.hm.oauth.business.UserService;
import edu.hm.oauth.business.UserServiceStub;

@Path("check")
public class CheckResource {

    private final CheckService checkService = new CheckServiceImpl();
    private final UserService userService = new UserServiceStub();
    @GET
    @Path("{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkToken(@PathParam("token") String token) {
        ServiceResult result = checkService.validateToken(token);
        return Response.ok().entity(result.getResult()).build();
    }
}