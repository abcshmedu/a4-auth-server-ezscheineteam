package edu.hm.oauth.repository;

import java.util.List;

import edu.hm.oauth.model.User;

/**
 * Interface for an user repository in this server.
 */
public interface UserRepository {

    /**
     * Lists all the stored users of the system.
     * 
     * @return List with saved user objects.
     */
    List<User> getAllUsers();

    /**
     * Saves a new user object to the stored users list.
     * 
     * @param user
     *            - the new user.
     * @return - True when adding was successful.
     */
    boolean createUser(User user);

    /**
     * Gets a specified user object.
     * 
     * @param userName
     *            - the name of the user.
     * @return - The user object if existing, null if not.
     */
    User getUser(String userName);

}
