package com.saveAccountDetails.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountUtils {
		private AccountUtils()
		{
			
		}
	
  public ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus)
  {
	  return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
  }
}
