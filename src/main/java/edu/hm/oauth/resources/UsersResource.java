package edu.hm.oauth.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hm.oauth.business.ServiceResult;
import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.business.UserService;
import edu.hm.oauth.business.UserServiceStub;
import edu.hm.oauth.model.AuthData;
import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;
import edu.hm.oauth.toolbox.Toolbox;

/**
 * Handles all request directed to the /users/ subpath.
 */
@Path("users")
public class UsersResource {

    private final UserService userService = new UserServiceStub();

    /**
     * Lists all saved users.
     * 
     * @return - A list of all users in the system.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUsers() {
        ServiceResult result = userService.getAllUsers();
        return Response.ok().entity(result.getResult()).build();
    }

    /**
     * Creates a new user object based on the information parsed from the JSON.
     * 
     * @param user
     *            - User informations - name, password, email address
     * @return - 200 OK if succeeded, error codes if not.
     */
    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        ServiceStatus status = userService.addUser(user);
        return Response.status(status.getStatus()).entity(status.getDetail()).build();
    }

    /**
     * Authenticates an user in the system. If passed credentials are correct,
     * then a new token is generated.
     * 
     * @param adata
     *            - Authentification data parsed from JSON.
     * @return A new token if credentials correct, error response otherwise.
     */
    @POST
    @Path("authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(AuthData adata) {
        // Check if credentials correct
        ServiceResult authResult = userService.authenticateUser(adata);

        if (authResult.getStatus().equals(ServiceStatus.OK)) {
            Token t = (Token) authResult.getResult();
            // generate token and return it
            String json = Toolbox.stringToJson("token", t.getTokenString());
            return Response.ok(json).build();
        } else {
            // authentication failed, pass error notification
            return Response.status(authResult.getStatus().getStatus()).entity(authResult).build();
        }
    }

    /**
     * Updates the stored user data with the given new one.
     * 
     * @param user
     *            - New user data parsed from JSON.
     * @return - Response according to the result status - operation succeeded
     *         or not.
     */
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        // the user can change only the password and email values
        ServiceResult getUserResult = userService.getUser(user.getName());

        // if user not found send error
        if (!getUserResult.getStatus().equals(ServiceStatus.OK)) {
            return Response.status(getUserResult.getStatus().getStatus()).entity(getUserResult).build();
        }
        // otherwise proceed
        ServiceResult updateResult = userService.updateUser(user);
        return Response.ok().entity(updateResult.getResult()).build();
    }

    /**
     * Gets the data of the user specified by the given id - the unique name.
     * 
     * @param id
     *            - the name of the user.
     * @return Response - user was found or not.
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserData(@PathParam("id") String id) {
        ServiceResult result = userService.getUser(id);
        return Response.status(result.getStatus().getStatus()).entity(result).build();
    }
}
