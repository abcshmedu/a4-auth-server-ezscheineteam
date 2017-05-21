package edu.hm.oauth.model;

import java.util.Date;

/**
 * Represents a token generated for an user.
 */
public class Token {

    private Date createdOn;
    private Date validUntil;
    private User user;

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

}
