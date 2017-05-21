package edu.hm.ouath.repository;

import edu.hm.oauth.business.ServiceStatus;
import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;

public interface TokenRepository {

    ServiceStatus generateToken(User user);

    ServiceStatus validateToken(Token token);

}
