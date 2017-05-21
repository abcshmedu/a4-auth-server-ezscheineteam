package edu.hm.ouath.repository;

import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.User;

public class UserRepositoryStub implements UserRepository {

    @Override
    public ServiceStatus getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ServiceStatus createUser(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ServiceStatus updateUser(String userID, User user) {
        // TODO Auto-generated method stub
        return null;
    }

}
