package edu.hm.oauth.business;

import edu.hm.oauth.model.Token;
import edu.hm.oauth.toolbox.TokenStringGenerator;
import edu.hm.ouath.repository.TokenRepository;
import edu.hm.ouath.repository.TokenRepositoryStub;

public class CheckServiceImpl implements CheckService {

    private final TokenRepository tokenRepository = new TokenRepositoryStub();

    
    public ServiceResult validateToken() {
        // TODO Auto-generated method stub
        //return ServiceStatus.OK;
        return new ServiceResult(ServiceStatus.OK, TokenStringGenerator.nextToken());
    }
    
    
    @Override
    public ServiceResult validateToken(Token token) {
        // TODO Auto-generated method stub
        //return ServiceStatus.OK;
        return new ServiceResult(ServiceStatus.OK, TokenStringGenerator.nextToken());
    }
}
