package com.taskTracker.exceptionHandler;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = ClientSideException.class)
	public ResponseEntity<Object> ClientException(ClientSideException exception)
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Message",exception.getMessage());
		return ResponseEntity.status(exception.getResourceId()).body(map);
	}

}
