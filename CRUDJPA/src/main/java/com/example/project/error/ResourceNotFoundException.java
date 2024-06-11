package com.example.project.error;

public class ResourceNotFoundException extends RuntimeException	{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message);
	}

}
