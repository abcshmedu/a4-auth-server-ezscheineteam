package edu.hm.oauth.resources;

import java.sql.Timestamp;

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
import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.Token;

@Path("check")
public class CheckResource {

    private final CheckService checkService = new CheckServiceImpl();
    
    @GET
    @Path("{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkToken(@PathParam("token")String inputToken) {
        Token token = new Token(new Timestamp(1495444780185),new Timestamp(1495444780185),"");
        ServiceResult result = checkService.validateToken(token);
        return Response.ok().entity(result.getResult()).build();
    }
}