package edu.hm.oauth.business;

import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;
import edu.hm.ouath.repository.TokenRepository;
import edu.hm.ouath.repository.TokenRepositoryStub;

public class CheckServiceImpl implements CheckService {

    private final TokenRepository tokenRepository = new TokenRepositoryStub();

    @Override
    public ServiceStatus validateToken(Token token) {
        // TODO Auto-generated method stub
        return ServiceStatus.OK;
    }

}
