package edu.hm.ouath.repository;

import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;

public interface TokenRepository {

	Token generateToken(User user);

    Token validateToken(String token);

}
