package edu.hm.oauth.toolbox;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class TokenStringGenerator {
	  private static SecureRandom random = new SecureRandom();

	  public static String nextToken() {
	    return new BigInteger(130, random).toString(128);
	  }
	}