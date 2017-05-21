package edu.hm.ouath.repository;

import edu.hm.oauth.business.ServiceResult;
import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.User;

public interface UserRepository {

    ServiceResult getAllUsers();
    
    ServiceStatus createUser(User user);
    
    ServiceStatus updateUser(String userID, User user);
    
    
    
}
