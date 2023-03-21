package com.Login.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


	@Component
	public class UserUtils {
		private UserUtils()
		{
			
		}
	  public ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus)
	  {
		  return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
	  }
	}


