package edu.hm.oauth.model;

/**
 * This class represents an user in the system. It stores values identifying a
 * single person.
 */
public class User {
	private String name;
	private String password;
	private int iD;
	private boolean active;
	private String email;
	private UserGroup group;

	/**
	 * Empty user object not allowed, hidden empty default constructor.
	 */
	private User() {
	}

	/**
	 * Constructor to be used when creating a new user object.
	 * 
	 * @param name
	 *            Name of this user.
	 * @param password
	 *            Password of this user.
	 * @param email
	 *            E-Mail address of this user.
	 * @param group
	 *            Group membership of this user.
	 */
	public User(String name, String password, String email, UserGroup group) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.group = group;
		this.active = true;
	}

	/**
	 * Gets the name of this user.
	 * 
	 * @return The name of this user.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this user.
	 * 
	 * @param name
	 *            The new name value for this user.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the password for this user.
	 * 
	 * @return The password of this user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password for this user.
	 * 
	 * @param password
	 *            The new password for this user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the ID for this user.
	 * 
	 * @return ID of the user.
	 */
	public int getiD() {
		return iD;
	}

	/**
	 * Sets the unique user ID.
	 * 
	 * @param iD
	 *            the user ID.
	 */
	public void setiD(int iD) {
		this.iD = iD;
	}

	/**
	 * Shows if the user is active and can perform actions.
	 * 
	 * @return True if active, false if not.
	 * 
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Activates or deactivates an user in this authorization system.
	 * 
	 * @param active
	 *            True for user activating, false for deactivating.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Shows the stored email address for this user.
	 * 
	 * @return The stored email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Changes the stored email address for this user.
	 * 
	 * @param email
	 *            The new email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Show the group membership for the given user.
	 * 
	 * @return group name of this user.
	 */
	public UserGroup getGroup() {
		return group;
	}

	/**
	 * Set the group membership for the given user.
	 * 
	 * @param group
	 *            New group name from enum.
	 */
	public void setGroup(UserGroup group) {
		this.group = group;
	}
}