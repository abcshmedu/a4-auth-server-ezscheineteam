package edu.hm.oauth.model;

import java.util.Date;

import edu.hm.oauth.toolbox.TokenStringGenerator;

/**
 * Represents a token generated for an user.
 */
public class Token {

	private String tokenString;
	private Date createdOn;
	private Date validUntil;
	private User user;

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
		this.tokenString = TokenStringGenerator.nextToken();
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

	public String getTokenString() {
		return tokenString;
	}

	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}

}
