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

	@Override
	public Token generateToken(User user) {
		Token token = new Token(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 60000l),
				user);
		storedTokens.add(token);
		return token;
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
