package edu.hm.oauth.business;

import java.util.Date;

import edu.hm.oauth.model.Token;
import edu.hm.oauth.repository.TokenRepository;
import edu.hm.oauth.repository.TokenRepositoryStub;

/**
 * Stub implementation of the check service.
 *
 */
public class CheckServiceImpl implements CheckService {

    private final TokenRepository tokenRepository = new TokenRepositoryStub();

    /**
     * Checks if the passed token is valid and returns some basic info about the
     * user that the token is assigned to.
     */
    @Override
    public ServiceResult validateToken(String token) {
        Token t = tokenRepository.validateToken(token);
        if (t == null) {
            return new ServiceResult(ServiceStatus.TOKEN_NOT_FOUND, "Token not found");
        }
        if (t.getValidUntil().before(new Date(System.currentTimeMillis()))) {
            
            return new ServiceResult(ServiceStatus.TOKEN_TIMEOUT, "Token is no longer valid.");
        }
        return new ServiceResult(ServiceStatus.OK, t);
    }
}
