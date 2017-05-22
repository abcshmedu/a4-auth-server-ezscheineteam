package edu.hm.oauth.business;

import java.util.List;

import edu.hm.oauth.model.User;
import edu.hm.ouath.repository.UserRepository;
import edu.hm.ouath.repository.UserRepositoryStub;

public class UserServiceStub implements UserService {

	private UserRepository userRepository = new UserRepositoryStub();

	@Override
	public ServiceStatus addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult authenticateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult getAllUsers() {
		List<User> result = userRepository.getAllUsers();
		return new ServiceResult(ServiceStatus.OK, result.toArray(new User[result.size()]));
	}

	@Override
	public ServiceResult getUser(String userID) {
		User user = userRepository.getUser(Integer.getInteger(userID));
		return new ServiceResult(ServiceStatus.OK, user);
	}

	@Override
	public ServiceStatus updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
