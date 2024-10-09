package com.curso.vnc.services.exceptions.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String mgs) {
		super(mgs);
	}
	
	public ObjectNotFoundException(String msg , Throwable cause) {
		super(msg, cause);
	}

}
