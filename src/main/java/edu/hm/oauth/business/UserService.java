package edu.hm.oauth.business;

import edu.hm.oauth.model.AuthData;
import edu.hm.oauth.model.User;

public interface UserService {

    ServiceStatus addUser(User user);

    ServiceResult getAllUsers();

    ServiceResult getUser(String userID);

    ServiceResult updateUser(User user);

	ServiceResult authenticateUser(AuthData adata);

}
