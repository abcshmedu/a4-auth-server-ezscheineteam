package edu.hm.oauth.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import edu.hm.oauth.model.Token;
import edu.hm.oauth.model.User;

/**
 * Stub implementation of a token repository.
 *
 */
public class TokenRepositoryStub implements TokenRepository {

    private static List<Token> storedTokens = new ArrayList<>();
    private static final long TOKEN_LIFETIME = 60000L;

    @Override
    public Token generateToken(User user) {
        Token token = new Token(new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis() + TOKEN_LIFETIME), user);

        // Remove previous token for this user
        Iterator<Token> iter = storedTokens.iterator();
        while (iter.hasNext()) {
            if (iter.next().getUser().getName().equals(user.getName())) {
                iter.remove();
            }
        }

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
