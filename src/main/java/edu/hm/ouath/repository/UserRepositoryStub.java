package edu.hm.ouath.repository;

import java.util.ArrayList;

import edu.hm.oauth.business.ServiceResult;
import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.User;
import edu.hm.oauth.model.UserGroup;

public class UserRepositoryStub implements UserRepository {

    private static int lastID = 0;
    private static final ArrayList<User> REGISTERED_USERS = new ArrayList<>();

    static {
        REGISTERED_USERS.add(new User("Rick Sanchez", "MyMorty", "grandpa@rick.xyz", UserGroup.ADMIN));
        REGISTERED_USERS.add(new User("Otto Waalkes", "Otto", "otto@waalkes.xyz", UserGroup.NORMAL));
        REGISTERED_USERS.add(new User("Robert Lewandowski", "Robercik", "Robert@Robert.xyz", UserGroup.NORMAL));
        REGISTERED_USERS.add(new User("Saul Goodman", "bettercallsaul", "saul@goodman.xyz", UserGroup.NORMAL));
        REGISTERED_USERS.add(new User("Walter White", "knockknock", "walter@white.xyz", UserGroup.NORMAL));
    }

    @Override
    public ServiceResult getAllUsers() {
        return new ServiceResult(ServiceStatus.OK, REGISTERED_USERS.toArray(new User[REGISTERED_USERS.size()]));
    }

    @Override
    public ServiceStatus createUser(User user) {

        return null;
    }

    @Override
    public ServiceStatus updateUser(String userID, User user) {
        // TODO Auto-generated method stub
        return null;
    }

    public static int getLastID() {
        return lastID;
    }

    public static void setLastID(int lastID) {
        UserRepositoryStub.lastID = lastID;
    }
}
