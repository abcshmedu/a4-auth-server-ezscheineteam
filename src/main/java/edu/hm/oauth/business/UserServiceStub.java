package edu.hm.oauth.business;

import java.util.List;

import edu.hm.oauth.model.AuthData;
import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;
import edu.hm.oauth.model.UserGroup;
import edu.hm.oauth.repository.TokenRepository;
import edu.hm.oauth.repository.TokenRepositoryStub;
import edu.hm.oauth.repository.UserRepository;
import edu.hm.oauth.repository.UserRepositoryStub;
import edu.hm.oauth.toolbox.Toolbox;

public class UserServiceStub implements UserService {

    private UserRepository userRepository = new UserRepositoryStub();
    private TokenRepository tokenRepository = new TokenRepositoryStub();

    @Override
    public ServiceStatus addUser(User user) {
        // check if user with this name already exists
        User testUser = userRepository.getUser(user.getName());
        if (testUser != null) {
            return ServiceStatus.USER_ALREADY_EXISTS;
        }

        // check if email regex correct
        if(!Toolbox.validateEmail(user.getEmail())){
            return ServiceStatus.USER_INVALID_EMAIL;
        }
        // clone required user data - name, email, password - other fields are
        // set by this server
        User newUser = new User(user.getName(), user.getPassword(), user.getEmail(), UserGroup.NORMAL);
        userRepository.createUser(newUser);
        return ServiceStatus.OK;
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
        if (user != null)
            return new ServiceResult(ServiceStatus.OK, user);
        else {
            return new ServiceResult(ServiceStatus.USER_NOT_FOUND, null);
        }
    }

    @Override
    public ServiceResult updateUser(User user) {
        // find that user
        User u = userRepository.getUser(user.getName());
        if (u == null) {
            return new ServiceResult(ServiceStatus.USER_NOT_FOUND, null);
        }
        // if user found proceed - only mail and password can be changed
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        return new ServiceResult(ServiceStatus.OK, u);
    }

}
