package edu.hm.oauth.repository;

import java.util.List;

import edu.hm.oauth.business.ServiceResult;
import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.User;

public interface UserRepository {

	List<User> getAllUsers();

	boolean createUser(User user);

	boolean updateUser(String userID, User user);

	User getUser(String userName);

}
