package edu.hm.oauth.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.hm.oauth.toolbox.Toolbox;

/**
 * Represents a token generated for an user.
 */
public class Token {
    @JsonIgnore
    private String tokenString;
    private Date createdOn;
    private Date validUntil;
    private User user;
    private boolean isActive;

    /**
     * Default empty constructor hidden.
     */
    private Token() {
    }

    /**
     * Constructor for generating tokens assigned to an user.
     * 
     * @param createdOn
     *            Date when token was created.
     * @param validUntil
     *            Date when token expires.
     * @param user
     *            User that this token is assigned to.
     */
    public Token(Date createdOn, Date validUntil, User user) {
        this.createdOn = createdOn;
        this.validUntil = validUntil;
        this.user = user;
        this.tokenString = Toolbox.nextToken();
        this.isActive = true;
    }

    /**
     * Gets the date when this token was generated.
     * 
     * @return Date when this token was generated.
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets the date of the token's creation.
     * 
     * @param createdOn
     *            New date value for when this token was created.
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * Gets the date till when this token is valid.
     * 
     * @return Date when this token invalidates.
     */
    public Date getValidUntil() {
        return validUntil;
    }

    /**
     * Sets the date till when this token is valid.
     * 
     * @param validUntil
     *            Date when this token invalidates.
     */
    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    /**
     * Get the user that the token was generated for.
     * 
     * @return The user referenced by this token.
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user that is the owner of this token.
     * 
     * @param user
     *            The user that the token was generated for.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get's the token string.
     * 
     * @return The token string.
     */
    public String getTokenString() {
        return tokenString;
    }

    /**
     * Set's the token string.
     * 
     * @param tokenString
     *            - The new random token string.
     */
    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    /**
     * 
     * @return True if token active, false if not.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the active field.
     * 
     * @param isActive
     *            Token active or not.
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

}
