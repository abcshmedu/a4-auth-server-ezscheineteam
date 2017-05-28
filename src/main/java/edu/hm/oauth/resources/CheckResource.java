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
import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.Token;

/**
 * Handles all request directed to the /check/ subpath.
 */
@Path("check")
public class CheckResource {

    private final CheckService checkService = new CheckServiceImpl();

    /**
     * Checks if a token is valid.
     * 
     * @param token
     *            - The token string.
     * @return - Informations about the token and the owner of this token.
     */
    @GET
    @Path("{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkToken(@PathParam("token") String token) {
        ServiceResult result = checkService.validateToken(token);
        if (result.getStatus().equals(ServiceStatus.OK)) {
            Token t = (Token) result.getResult();
            return Response.status(result.getStatus().getStatus()).entity(t).build();
        }
        return Response.status(result.getStatus().getStatus()).entity(result).build();
    }
}