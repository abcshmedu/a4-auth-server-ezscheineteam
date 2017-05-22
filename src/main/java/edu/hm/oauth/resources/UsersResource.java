package edu.hm.oauth.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hm.oauth.business.CheckService;
import edu.hm.oauth.business.CheckServiceImpl;
import edu.hm.oauth.business.ServiceResult;
import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.business.UserService;
import edu.hm.oauth.business.UserServiceStub;
import edu.hm.oauth.model.AuthData;

@Path("users")
public class UsersResource {

	private final UserService userService = new UserServiceStub();
	private final CheckService checkService = new CheckServiceImpl();

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listUsers() {
		ServiceResult result = userService.getAllUsers();
		return Response.ok().entity(result.getResult()).build();
	}

	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser() {
		// Copy copy = new Copy(user, book);
		// ServiceStatus result = copyService.addBook(copy);
		return Response.ok("response").build();
	}

	@POST
    @Path("authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(AuthData adata) {
    	// Check if credentials correct
		ServiceResult authResult = userService.authenticateUser(adata);
    	
    	if(authResult.getStatus().equals(ServiceStatus.OK)){
    		//generate token and return it
    		return Response.ok("response").build();
    	}
    	else{
    		// authentication failed, pass error notification
    		return Response.status(authResult.getStatus().getStatus()).entity(authResult).build();
    	}
    	// TODO: deactivate previous tokens for this user
    }

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser() {
		// Copy copy = new Copy(user, book);
		// ServiceStatus result = copyService.addBook(copy);
		return Response.ok("response").build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserData() {
		// Copy copy = new Copy(user, book);
		// ServiceStatus result = copyService.addBook(copy);
		return Response.ok("response").build();
	}

}
