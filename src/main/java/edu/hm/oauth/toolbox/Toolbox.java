package edu.hm.oauth.toolbox;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Toolbox {
    private static SecureRandom random = new SecureRandom();
    private static int id = 0;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
            .compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

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

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}