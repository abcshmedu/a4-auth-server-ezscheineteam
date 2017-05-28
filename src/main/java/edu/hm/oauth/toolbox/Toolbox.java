package edu.hm.oauth.toolbox;

import java.security.SecureRandom;
import java.util.UUID;

public final class Toolbox {
    private static SecureRandom random = new SecureRandom();
    private static int id = 0;

    public static String nextToken() {
        String uuid = UUID.randomUUID().toString();
        uuid += "-" + UUID.randomUUID().toString();
        uuid += "-" + UUID.randomUUID().toString();
        uuid += "-" + UUID.randomUUID().toString();
        return uuid;
    }

    public static int nextID() {
        id += 1;
        return id;
    }

    public static String stringToJson(String name, String inputString) {
        return "{ \"" + name + "\" : \"" + inputString + "\"}";
    }
}