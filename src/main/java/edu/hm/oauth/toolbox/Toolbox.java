package edu.hm.oauth.toolbox;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains simple different methods.
 */
public final class Toolbox {
    private static int id = 0;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
            .compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Hidden default constructor
     */
    private Toolbox() {
    }

    /**
     * Generates a random token string.
     * 
     * @return String with the new random token.
     */
    public static String nextToken() {
        String uuid = UUID.randomUUID().toString();
        uuid += "-" + UUID.randomUUID().toString();
        uuid += "-" + UUID.randomUUID().toString();
        uuid += "-" + UUID.randomUUID().toString();
        return uuid;
    }

    /**
     * Counter for the user ID numbers.
     * 
     * @return Incremented ID number.
     */
    public static int nextID() {
        id += 1;
        return id;
    }

    /**
     * Creates a simple JSON string for one value.
     * 
     * @param name
     *            - Name of the field.
     * @param inputString
     *            - Value of the field.
     * @return JSON String.
     */
    public static String stringToJson(String name, String inputString) {
        return "{ \"" + name + "\" : \"" + inputString + "\"}";
    }

    /**
     * Validates an email address.
     * 
     * @param emailStr
     *            - The input email address.
     * @return - True if email address is correct, false otherwise.
     */
    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}