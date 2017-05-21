package edu.hm.ouath.repository;

import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;

public class TokenRepositoryStub implements TokenRepository {

    @Override
    public ServiceStatus generateToken(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ServiceStatus validateToken(Token token) {
        // TODO Auto-generated method stub
        return null;
    }

}
