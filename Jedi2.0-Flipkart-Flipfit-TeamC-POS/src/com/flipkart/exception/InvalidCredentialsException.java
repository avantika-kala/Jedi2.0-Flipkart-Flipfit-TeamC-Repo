package com.flipkart.exception;
/**
 * @author avantika
 */
public class InvalidCredentialsException extends Exception {
	public InvalidCredentialsException() {
		super("Invalid Credentials : Username or Password is wrong");
	}
}
