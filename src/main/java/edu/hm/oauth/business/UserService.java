package edu.hm.oauth.business;

import edu.hm.oauth.model.User;

public interface UserService {

    ServiceStatus addUser(User user);

    ServiceResult authenticateUser(User user);

    ServiceStatus getAllUsers();

    ServiceStatus getUser(String userID);

    ServiceStatus updateUser(User user);

}
