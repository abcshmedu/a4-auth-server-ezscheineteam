package edu.hm.oauth.business;

import edu.hm.oauth.model.Token;
import edu.hm.oauth.repository.TokenRepository;
import edu.hm.oauth.repository.TokenRepositoryStub;
import edu.hm.oauth.toolbox.Toolbox;

public class CheckServiceImpl implements CheckService {

	private final TokenRepository tokenRepository = new TokenRepositoryStub();

	/**
	 * Checks if the passed token is valid and returns some basic info about the
	 * user that the token is assigned to.
	 */
	@Override
	public ServiceResult validateToken(String token) {
		Token t = tokenRepository.validateToken(token);
		if(t == null){
			return new ServiceResult(ServiceStatus.TOKEN_NOT_FOUND, "Token not found");
		}
		return new ServiceResult(ServiceStatus.OK, t);
	}
}
