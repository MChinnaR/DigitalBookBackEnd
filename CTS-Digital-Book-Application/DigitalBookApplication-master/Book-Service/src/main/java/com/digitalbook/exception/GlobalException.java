package com.digitalbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = NoSuchBookExistsException.class)
	@ResponseStatus(value = HttpStatus.NO_CONTENT,code = HttpStatus.NO_CONTENT,reason = "No Book Details For the Give Input")
	private ResponseEntity<ErrorMessage> handleException(NoSuchBookExistsException e){
		ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NO_CONTENT.value(),e.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(value = BookExistWithTittle.class)
	@ResponseStatus(value = HttpStatus.CONFLICT,code = HttpStatus.CONFLICT,reason = "Book Already Exist For the Give Tittle")
	private ResponseEntity<ErrorMessage> handleBookExistWithTittleException(BookExistWithTittle e){
		ErrorMessage errorMessage=new ErrorMessage(HttpStatus.CONFLICT.value(),e.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.CONFLICT);
	}

}
