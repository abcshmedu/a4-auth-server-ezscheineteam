package edu.hm.oauth.model;

/**
 * Simple class to allow pass the name and password of an user in the JSON.
 */
public class AuthData {

    private String name;
    private String password;

    /**
     * Hidden default constructor.
     */
    private AuthData() {
    }

    /**
     * Use this constructor.
     * 
     * @param name
     *            - Name of the user.
     * @param password
     *            - Password.
     */
    public AuthData(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * 
     * @return The passed name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the passed name.
     * 
     * @param name
     *            - Name parameter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the passed password.
     * 
     * @return The password parsed from the JSON.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password
     *            - The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
