package edu.hm.oauth.business;

import edu.hm.oauth.model.Token;
import edu.hm.oauth.toolbox.TokenStringGenerator;
import edu.hm.ouath.repository.TokenRepository;
import edu.hm.ouath.repository.TokenRepositoryStub;

public class CheckServiceImpl implements CheckService {

	private final TokenRepository tokenRepository = new TokenRepositoryStub();

	/**
	 * Checks if the passed token is valid and returns some basic info about the
	 * user that the token is assigned to.
	 */
	@Override
	public ServiceResult validateToken(String token) {
		tokenRepository.validateToken(token);
		return new ServiceResult(ServiceStatus.OK, TokenStringGenerator.nextToken());
	}
}
