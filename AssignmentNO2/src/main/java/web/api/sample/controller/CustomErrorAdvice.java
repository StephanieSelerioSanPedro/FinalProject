package web.api.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import web.api.sample.controller.model.CustomError;
import web.api.sample.controller.model.MessageType;
import web.api.sample.exception.CustomException;
/**
 *This class handles error in a proper way.
 * @author Stephanie San Pedro
 *
 */
@ControllerAdvice
public class CustomErrorAdvice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<CustomError> handleException(CustomException ex) {
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		System.out.println("ERROR MESSAGE -> " + ex.getMessage());
		
		if(MessageType.RECORD_NOT_FOUND.getCode().equals(ex.getMessage())) {
			System.out.println("I have caught that exception.....");
			status = HttpStatus.NOT_FOUND;
		}
		
		CustomError error = new CustomError(ex.getMessage(), status);
		return new ResponseEntity<CustomError>(error ,status);	
	}
}