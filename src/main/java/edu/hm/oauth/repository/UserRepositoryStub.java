package edu.hm.oauth.repository;

import java.util.ArrayList;
import java.util.List;

import edu.hm.oauth.model.User;
import edu.hm.oauth.model.UserGroup;

/**
 * Stub implementation of the user repository.
 */
public class UserRepositoryStub implements UserRepository {

    private static final ArrayList<User> REGISTERED_USERS = new ArrayList<>();

    static {
        REGISTERED_USERS.add(new User("RickSanchez", "MyMorty", "grandpa@rick.xyz", UserGroup.ADMIN));
        REGISTERED_USERS.add(new User("OttoWaalkes", "Otto", "otto@waalkes.xyz", UserGroup.NORMAL));
        REGISTERED_USERS.add(new User("RobertLewandowski", "Robercik", "Robert@Robert.xyz", UserGroup.NORMAL));
        REGISTERED_USERS.add(new User("SaulGoodman", "bettercallsaul", "saul@goodman.xyz", UserGroup.NORMAL));
        REGISTERED_USERS.add(new User("WalterWhite", "knockknock", "walter@white.xyz", UserGroup.NORMAL));
    }

    /**
     * Returns the list of all stored users.
     * 
     * @return List of all users.
     */
    @Override
    public List<User> getAllUsers() {
        return REGISTERED_USERS;
    }

    /**
     * Adds a new user to the list of stored users.
     * 
     * @param user
     *            - Data of the new user.
     * @return True if adding was successful.
     */
    @Override
    public boolean createUser(User user) {
        return REGISTERED_USERS.add(user);
    }

    /**
     * Gets an user object from the list with stored users.
     * 
     * @param userName
     *            - The unique user name.
     * @return The user object or null if not found.
     */
    @Override
    public User getUser(String userName) {
        for (User u : REGISTERED_USERS) {
            if (u.getName().equals(userName)) {
                return u;
            }
        }
        return null;
    }
}
