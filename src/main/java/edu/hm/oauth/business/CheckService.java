package edu.hm.oauth.business;

import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;

/**
 * Interface for token related functionality.
 */
public interface CheckService {
	ServiceResult validateToken(Token token);
}
