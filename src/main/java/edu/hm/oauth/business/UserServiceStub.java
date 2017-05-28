package edu.hm.oauth.business;

import java.util.List;

import edu.hm.oauth.model.AuthData;
import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;
import edu.hm.oauth.repository.TokenRepository;
import edu.hm.oauth.repository.TokenRepositoryStub;
import edu.hm.oauth.repository.UserRepository;
import edu.hm.oauth.repository.UserRepositoryStub;

public class UserServiceStub implements UserService {

	private UserRepository userRepository = new UserRepositoryStub();
	private TokenRepository tokenRepository = new TokenRepositoryStub();

	@Override
	public ServiceStatus addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult authenticateUser(AuthData adata) {
		String name = adata.getName();
		String password = adata.getPassword();
		List<User> users = userRepository.getAllUsers();
		for (User u : users) {
			if (u.getName().equals(name)) {
				if (u.getPassword().equals(password)) {
					// user authenticated, generate token and return it
					Token resultToken = tokenRepository.generateToken(u);
					return new ServiceResult(ServiceStatus.OK, resultToken);
				}
				return new ServiceResult(ServiceStatus.USER_INVALID_CREDENTIALS);
			}
		}
		return new ServiceResult(ServiceStatus.USER_NOT_FOUND);

	}

	@Override
	public ServiceResult getAllUsers() {
		List<User> result = userRepository.getAllUsers();
		return new ServiceResult(ServiceStatus.OK, result.toArray(new User[result.size()]));
	}

	@Override
	public ServiceResult getUser(String userID) {
		User user = userRepository.getUser(userID);
		if(user != null)
		    return new ServiceResult(ServiceStatus.OK, user);
		else{
		    return new ServiceResult(ServiceStatus.USER_NOT_FOUND, null);
		}
	}

	@Override
	public ServiceStatus updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
