package edu.hm.oauth.business;

import edu.hm.oauth.model.AuthData;
import edu.hm.oauth.model.User;

/**
 * Interface for an user service. Handles the functionality in the user domain.
 *
 */
public interface UserService {

    /**
     * Adds a new user to the system.
     * 
     * @param user
     *            - The new user.
     * @return OK if succeeded, error otherwise.
     */
    ServiceStatus addUser(User user);

    /**
     * Gets a list of all registered users.
     * 
     * @return - List of all users or an error message.
     */
    ServiceResult getAllUsers();

    /**
     * Gets the user specified by the userID name string.
     * 
     * @param userID
     *            - Name of the user
     * @return Result - ok and user object or error
     */
    ServiceResult getUser(String userID);

    /**
     * Updates user data.
     * 
     * @param user
     *            New user data
     * @return OK if succeeded or error message.
     */
    ServiceResult updateUser(User user);

    /**
     * Authenticates an user in the system.
     * 
     * @param adata
     *            Name and password for the user.
     * @return OK and new token when credentials correct, error if wrong.
     */
    ServiceResult authenticateUser(AuthData adata);

}
