package com.rajat.ecommerce.exceptions;

public class CLientNotFoundException extends RuntimeException{
	public CLientNotFoundException(){
		
	}
	
	public CLientNotFoundException(String message) {
		super(message);
	}
}
