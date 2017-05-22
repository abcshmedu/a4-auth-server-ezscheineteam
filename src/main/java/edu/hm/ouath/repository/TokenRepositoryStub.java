package edu.hm.ouath.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;

public class TokenRepositoryStub implements TokenRepository {

	private static List<Token> storedTokens = new ArrayList<>();
	private static UserRepository userRepository = new UserRepositoryStub();
	
	static{
		storedTokens.add(new Token(new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),userRepository.getUser(1)));
		storedTokens.add(new Token(new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),userRepository.getUser(2)));
		storedTokens.add(new Token(new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),userRepository.getUser(3)));
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
