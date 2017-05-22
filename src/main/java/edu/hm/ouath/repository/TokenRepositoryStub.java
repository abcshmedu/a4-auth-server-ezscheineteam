package edu.hm.ouath.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.hm.oauth.business.ServiceResult;
import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;

public class TokenRepositoryStub implements TokenRepository {

	private static List<Token> storedTokens = new ArrayList<>();
	private static UserRepository userRepository = new UserRepositoryStub();

	static {
		storedTokens.add(new Token(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()),
				userRepository.getUser(1)));
		storedTokens.add(new Token(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()),
				userRepository.getUser(2)));
		storedTokens.add(new Token(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()),
				userRepository.getUser(3)));
	}

	@Override
	public Token generateToken(User user) {
		Token token = new Token(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), user);
		storedTokens.add(token);
		return null;
	}

	@Override
	public Token validateToken(String inputTokenString) {
		for (Token t : storedTokens) {
			if (t.getTokenString().equals(inputTokenString)) {
				return t;

			}
		}
		return null;
	}

}
