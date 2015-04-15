package com.tieto.MVPPattern;

/**
 * This is model.
 * @author survesac
 *
 */
public class User {
	private String username;
	private String password;
	
	public User(String username2, String password2) {
		this.username = username2;
		this.password = password2;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

}
