package edu.hm.oauth.toolbox;

import java.security.SecureRandom;
import java.util.UUID;

public final class TokenStringGenerator {
	private static SecureRandom random = new SecureRandom();

	public static String nextToken() {
		String uuid = UUID.randomUUID().toString();
		uuid += "-" + UUID.randomUUID().toString();
		uuid += "-" + UUID.randomUUID().toString();
		uuid += "-" + UUID.randomUUID().toString();
		return uuid;
	}
}