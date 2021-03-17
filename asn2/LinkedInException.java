package edu.institution.asn2;

public class LinkedInException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LinkedInException() {
		super();
	}
	
	public LinkedInException(String message) {
		super(message);
	}
	
	public LinkedInException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public LinkedInException(String message, Throwable cause, boolean enableSuppression, boolean writeableStackTrace) {
		super(message, cause, enableSuppression, writeableStackTrace);
	}
	
	public LinkedInException(Throwable cause) {
		super(cause);
	}
	
}
