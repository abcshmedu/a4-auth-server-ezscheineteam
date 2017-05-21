package edu.hm.oauth.business;

import edu.hm.oauth.model.Token;

/**
 * 
 *
 */
public interface CheckService {
    ServiceStatus checkToken(Token token);
}
