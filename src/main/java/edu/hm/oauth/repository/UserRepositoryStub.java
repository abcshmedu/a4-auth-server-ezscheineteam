package edu.hm.oauth.repository;

import java.util.ArrayList;
import java.util.List;

import edu.hm.oauth.model.User;
import edu.hm.oauth.model.UserGroup;

public class UserRepositoryStub implements UserRepository {

    private static int lastID = 0;
    private static final ArrayList<User> REGISTERED_USERS = new ArrayList<>();

    static {
        REGISTERED_USERS.add(new User("RickSanchez", "MyMorty", "grandpa@rick.xyz", UserGroup.ADMIN));
        REGISTERED_USERS.add(new User("OttoWaalkes", "Otto", "otto@waalkes.xyz", UserGroup.NORMAL));
        REGISTERED_USERS.add(new User("RobertLewandowski", "Robercik", "Robert@Robert.xyz", UserGroup.NORMAL));
        REGISTERED_USERS.add(new User("SaulGoodman", "bettercallsaul", "saul@goodman.xyz", UserGroup.NORMAL));
        REGISTERED_USERS.add(new User("WalterWhite", "knockknock", "walter@white.xyz", UserGroup.NORMAL));
    }

    @Override
    public List<User> getAllUsers() {
        return REGISTERED_USERS;
    }

    @Override
    public boolean createUser(User user) {
        return REGISTERED_USERS.add(user);
    }

    @Override
    public boolean updateUser(String userID, User user) {
        return false;
    }

    public static int getLastID() {
        return lastID;
    }

    public static void setLastID(int lastID) {
        UserRepositoryStub.lastID = lastID;
    }

    @Override
    public User getUser(String userName) {
        // TODO: make it better
        for (User u : REGISTERED_USERS)
            if (u.getName().equals(userName))
                return u;
        return null;
    }
}
