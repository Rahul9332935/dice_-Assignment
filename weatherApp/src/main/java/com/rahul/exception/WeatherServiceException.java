package com.rahul.exception;

public class WeatherServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WeatherServiceException() {
		
	}
	public WeatherServiceException(String message) {
		super(message);
	}
	public WeatherServiceException(String message, Exception cause) {
        super(message, cause);
    }
}
