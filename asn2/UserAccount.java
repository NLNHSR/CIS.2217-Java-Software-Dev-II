package edu.institution.asn2;

import java.io.Serializable;

public abstract class UserAccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 135688228421516010L;
	/**
	 * 
	 */
	private String username;
	private String password; 
	
	// a constructor accepting two Strings; one to initiate the user name and the other to
	// initiate the password
	public UserAccount(String username, String password) {
		this.username = username;
		this.password = password;
		
	}
	
	// returns the user name supplied on the constructor
	public String getUsername() {
		return username;
		
	}
	
	// return true if the argument is the same as this account’s password,
	// false otherwise
	public boolean isPasswordCorrect(String password) {
		return (this.password.equals(password) && password!= null);
		
	}
	
	// displays the username for the account.
	@Override
	public String toString() {
		return this.username;
	}
	
	// uses the username as the unique identifier of an account
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	// two accounts are equal if their user names are identical
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}	
	
	public abstract void setType(String type);
	
}
