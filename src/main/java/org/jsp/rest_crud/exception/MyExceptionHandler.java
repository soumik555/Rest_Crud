package org.jsp.rest_crud.exception;

import org.jsp.rest_crud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class MyExceptionHandler 
{
	@Autowired
	ResponseStructure structure;
	
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseStructure> handle(DataNotFoundException exception)
	{
		structure.setData(exception.getMessage());
		structure.setMessage("Data Not Present");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	

}
