package com.rajat.ecommerce.exceptions;

public class ClientExistsException extends RuntimeException{
	public ClientExistsException() {
		
	}
	
	public ClientExistsException(String message) {
		super(message);
	}
}
