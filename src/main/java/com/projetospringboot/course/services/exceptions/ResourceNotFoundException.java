package com.projetospringboot.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) { //exceçao personalizada para quando procurar um id que nao existe
		super("Resource not found. Id " + id);
	}

}
