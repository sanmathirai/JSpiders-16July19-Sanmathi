package com.ustglobal.exception.customizeduncheckedexception;

public class InvalidAgeException  extends RuntimeException{
	
	String message = "Invalid age below 18 years not allowed";
	
	public InvalidAgeException() {
		
	}
	
	/*
	 * @Override public String getMessage() { return message; }
	 */
	public InvalidAgeException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidAgeException [message=" + message + "]";
	}
	
}
