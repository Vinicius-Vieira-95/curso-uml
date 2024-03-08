package com.curso.vnc.services.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.curso.vnc.services.exceptions.exceptions.ObjectNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<Object> handlerObjectNotFoundException(ObjectNotFoundException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String error = "Recurso não encontrado!";
		CustomErrorResponse errorResponse = new CustomErrorResponse(status.value(), error, ex.getMessage());
		return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), status, request);
	}
}
