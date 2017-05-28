package edu.hm.oauth.repository;

import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;

/**
 * Interface for a token repository.
 */
public interface TokenRepository {

    /**
     * Creates a new token for the specified user and deletes the previos one if
     * existing.
     * 
     * @param user
     *            - authenticated user.
     * @return The new token for this user.
     */
    Token generateToken(User user);

    /**
     * Get's the token with this string.
     * 
     * @param token
     *            The token string
     * @return The token if found, null if not.
     */
    Token validateToken(String token);

}
