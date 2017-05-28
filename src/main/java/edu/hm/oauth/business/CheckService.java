package edu.hm.oauth.business;

/**
 * Interface for token related functionality.
 */
public interface CheckService {
    /**
     * Validates a token string, checks if it is correct.
     * 
     * @param inputToken
     *            - the token string
     * @return OK and user data if token string correct, error if wrong.
     */
    ServiceResult validateToken(String inputToken);
}
