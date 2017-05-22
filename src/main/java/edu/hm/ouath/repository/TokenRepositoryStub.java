package edu.hm.ouath.repository;

import java.util.ArrayList;
import java.util.List;

import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;

public class TokenRepositoryStub implements TokenRepository {

	private static List<Token> storedTokens = new ArrayList<>();
	
	static{
		storedTokens.add(new Token());
		storedTokens.add(new Token());
		storedTokens.add(new Token());
	}
	
    @Override
    public ServiceStatus generateToken(User user) {
    	
        return null;
    }

    @Override
    public ServiceStatus validateToken(Token token) {
        return ServiceStatus.OK;
    }

}
